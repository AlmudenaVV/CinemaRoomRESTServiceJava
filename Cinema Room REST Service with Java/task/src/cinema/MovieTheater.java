/* package cinema;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MovieTheater {
    int rows = 9;
    int columns = 9;
    List<Seats> seats;

    public MovieTheater(){
        seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                seats.add(new Seats(i, j));
            }
        }
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public List<Seats> getSeats(){
        return seats;
    }
}

 */


