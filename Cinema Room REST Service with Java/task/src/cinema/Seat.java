package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    int row;
    int column;
    int price;
    @JsonIgnore
    String token;

    public Seat(int row, int column){
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.token = null;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public int getPrice(){
        return price;
    }

    public void purchased(String token){
        this.token = token;

    }

    public void notPurchased(){
        this.token = null; // when ticket is returned, change token to null (call in the other class)
    }

}


