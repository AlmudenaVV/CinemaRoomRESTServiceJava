package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TheaterController {
    int numberRows = 9;
    int numberColumns = 9;
    List<Seat> seats = new ArrayList<>();

    public TheaterController() {
        for (int row = 1; row <= numberRows; row++){
            for (int column = 1; column <= numberColumns; column++){
                seats.add(new Seat(row, column));
            }
        }
    }

    @GetMapping("/seats")
    public ResponseEntity<Map<String, Object>> getSeats() {

        Map<String, Object> response = new HashMap<>();
        response.put("rows", numberRows);
        response.put("columns", numberColumns);
        response.put("seats", getAvailableSeats());

        return ResponseEntity.ok(response);
    }

    private List<Map<String, Object>> getAvailableSeats() { // map string so sprinboot automatically changes it into JSON
        List<Map<String, Object>> availableSeats = new ArrayList<>(); // make map object
        for (Seat seat : seats) {
            if (seat.token == null) { // go through list again, add the ones that are not taken
                Map<String, Object> seatInfo = new HashMap<>();
                seatInfo.put("row", seat.getRow());
                seatInfo.put("column", seat.getColumn());
                seatInfo.put("price", seat.price);
                availableSeats.add(seatInfo);
            }
        }
        return availableSeats;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase (@RequestBody Seat seatRequest) {
        if (seatRequest.row > 9 || seatRequest.row < 1 ||
        seatRequest.column > 9 || seatRequest.column < 1){
            return ResponseEntity.badRequest().body(new ErrorResponse("The number of a row or a column is out of bounds!"));

        }
        for (Seat seat : seats){ // goes through the list, takes the taken ones
            if (seat.row == seatRequest.row && seat.column == seatRequest.column){
                if (seat.token != null){ // check if it has token, if so, it's purchased
                    return ResponseEntity.badRequest().body(new ErrorResponse("The ticket has been already purchased!"));
                }
                String token = UUID.randomUUID().toString(); // create token for each purchased seat

                seat.purchased(token);
                Map<String, Object> response = new HashMap<>();

                response.put("token", token);
                response.put("ticket", seat); // remove row, column, price, cause the seat has all those three elements

                return ResponseEntity.ok(response);

            }
        }
        return ResponseEntity.badRequest().body(new ErrorResponse("The number of a row or a column is out of bounds!"));
    }

    @PostMapping("/return")
    public ResponseEntity<?> refund(@RequestBody RefundRequest request){
        for (Seat seat : seats) { // loop through seats
            if (Objects.equals(seat.token, request.token())) {
                Map<String, Object> seatInfo = new HashMap<>();

                seatInfo.put("ticket", seat); // remove row, column, price, cause the seat has all those three elements

                seat.notPurchased(); // method that changes token into null
                return ResponseEntity.ok(seatInfo); // prints out
            }

        }
        return ResponseEntity.badRequest().body(new ErrorResponse("Wrong token!"));
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(required = false) String password){
        // required equals false so it's not mandatory
        if (!"super_secret".equals(password)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("The password is wrong!"));
        }
        Statistics statistics = new Statistics(seats);
        return ResponseEntity.ok(statistics.getStatistics());
    }

}