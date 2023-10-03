package J1SP0023;

public class Fruit {

    private int fruitID;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    private Validation validation = new Validation();

    public Fruit createFruit() {
        System.out.print("Input fruit id: ");
        this.fruitID = validation.getInt();
        System.out.print("Input fruit name: ");
        this.fruitName = validation.getString();
        System.out.print("Input price: ");
        this.price = validation.getDouble();
        System.out.print("Input quantity: ");
        this.quantity = validation.getInt();
        System.out.print("Input origin: ");
        this.origin = validation.getString();
        return this;
    }

}
