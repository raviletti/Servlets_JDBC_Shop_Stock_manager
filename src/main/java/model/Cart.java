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

    public double getTotal(){
        sum = 0;
        for(Fan fan : fanList){
           sum += fan.getPrice() * fan.getQuantity();
        }
        return sum;
    }

    public double getTotalStream(){
        return fanList.stream().mapToDouble(Fan::getPrice).sum();
    }

}
