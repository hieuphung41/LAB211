package J1SP0023;

import java.util.ArrayList;
import java.util.Hashtable;

public class OrderList {
    Hashtable<String, ArrayList<Order>> orderList = new Hashtable<>();
    ArrayList<Order> order = new ArrayList<>();
    private Validation validation = new Validation();

    public void displayOrders() {
        for (String name : orderList.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> OL = orderList.get(name);
            display(OL);
        }
    }

    public void display(ArrayList<Order> OL) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Order x : OL) {
            System.out.println(x.getFruitName() + "\t\t" + x.getQuantity() + "\t\t" + x.getPrice() + "\t\t" + x.getQuantity());
            total += x.getPrice() * x.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void shopping(FruitList FL, OrderList OL) {
        int id;
        while (true) {
            if (FL.fruitList.isEmpty()) {
                System.err.println("No fruit!");
                break;
            }
            FL.displayFruits();
            System.out.print("Select item to buy: ");
            id = validation.getInt();
            Fruit fruit = FL.getFruit(id);
            System.out.println("You selected: " + fruit.getFruitName());
            System.out.print("Please input quantity: ");
            int quantity = validation.getIntInRange(0, fruit.getQuantity());
            buyFruit(FL, id, quantity);
            System.out.println("Do you want to continue (Y/N)? ");
            if (!validation.getYN()) {
                break;
            }
        }
        if (order.isEmpty()) {
            return;
        }
        OL.display(order);
        System.out.print("Enter name: ");
        String name = validation.getString();
        orderList.put(name, OL.order);
        System.err.println("Added successfully!");
    }

    public void buyFruit(FruitList fruitList, int id, int quantity) {
        Order order1 = new Order();
        Fruit fruit = fruitList.getFruit(id);
        if (fruit == null) {
            System.out.println("No fruit!");
            return;
        }
        Order newOrder = getOrderByID(id);
        if (newOrder != null) {
            newOrder.setQuantity(newOrder.getQuantity() + quantity);
        } else {
            order1.createOrder(fruit, quantity);
            order.add(order1);
        }
        if ((fruit.getQuantity() - quantity) == 0) {
            fruitList.removeFruit(fruit);
        } else {
            fruit.setQuantity(fruit.getQuantity() - quantity);
        }
    }

    public Order getOrderByID(int id) {
        for (Order x : order) {
            if (x.getFruitID() == id) {
                return x;
            }
        }
        return null;
    }

}
