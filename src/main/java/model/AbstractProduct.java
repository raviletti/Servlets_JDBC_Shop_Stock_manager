package model;

public abstract class AbstractProduct {
    private int id;
    private String modelName;
    private int price;
    private double volume;
    private double count;
    private double weight;



    public abstract AbstractProduct getTotal();

}
