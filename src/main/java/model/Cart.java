package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Fan> fanList = new ArrayList<>();
    private Fan fan;
    private double sum;

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public List<Fan> getFans() {
        return fanList;
    }

    public double getSum() {
        return sum;
    }

    public boolean isCartEmpty(){
        sum = 0.0;
        for(Fan fan : fanList){
           sum += fan.getPrice() * fan.getQuantity();
        }
        if(sum <= 0.0){
            return true;
        }
        else return false;
    }


}
