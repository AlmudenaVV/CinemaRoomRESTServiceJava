package cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    int income = 0;
    int available = 81;
    int purchased = 0;

    public Statistics(List<Seat> seats){
        for (Seat seat : seats) {
            if (seat.token != null){
                income = income + seat.price;
                available -= 1;
                purchased += 1;
            }
        }
    }
    public Map<String, Object> getStatistics(){
        Map<String, Object> response = new HashMap<>();
        response.put("income", income);
        response.put("available", available);
        response.put("purchased", purchased);

        return response;
    }
}
