package J1SP0023;

public class Order {

    private int fruitID;
    private String fruitName;
    private double price;
    private int quantity;

    public Order() {
    }

    public Order(int fruitID, String fruitName, double price, int quantity) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getFruitID() {
        return fruitID;
    }

    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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

    private Validation validation = new Validation();

    public Order createOrder(Fruit fruit, int quantity) {
        this.fruitID = fruit.getFruitID();
        this.fruitName = fruit.getFruitName();
        this.price = fruit.getPrice();
        this.quantity = quantity;
        return this;
    }
}
