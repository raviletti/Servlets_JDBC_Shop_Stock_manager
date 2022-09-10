package model;

public class Fan extends AbstractProduct {
    private int id;
    private String modelName;
    private String producerName;
    private int quantity;
    private double volume;
    private double weight;
    private int inOrder;
    private int freeStock;
    private String location;
    private String description;


    private double price;

    public Fan(int id, String modelName, String producerName, int quantity, double volume,
               double weight, int inOrder, int freeStock, String location, String description) {
        this.id = id;
        this.modelName = modelName;
        this.producerName = producerName;
        this.quantity = quantity;
        this.volume = volume;
        this.weight = weight;
        this.inOrder = inOrder;
        this.freeStock = freeStock;
        this.location = location;
        this.description = description;
    }

    public Fan(String modelName, String producerName, int quantity, double volume,
               double weight,int inOrder, String location, String description) {
        this.modelName = modelName;
        this.producerName = producerName;
        this.quantity = quantity;
        this.volume = volume;
        this.weight = weight;
        this.inOrder = inOrder;
        this.location = location;
        this.description = description;
    }



    @Override
    public String toString() {
        return "Fan{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", producerName='" + producerName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", volume=" + volume +
                ", weight=" + weight +
                '}';
    }

    @Override
    public Fan getTotal() {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getInOrder() {
        return inOrder;
    }

    public void setInOrder(int inOrder) {
        this.inOrder = inOrder;
    }

    public int getFreeStock() {
        return freeStock;
    }

    public void setFreeStock(int freeStock) {
        this.freeStock = freeStock;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
