package J1SP0023;

import java.util.ArrayList;
import java.util.Hashtable;

public class OrderList {
    Hashtable<String, ArrayList<Order>> orderList = new Hashtable<>();
    private Validation validation = new Validation();

    public void displayOrders() {
        for (String name : orderList.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> OL = orderList.get(name);
            displayOrderList(OL);
        }
    }

    public void shopping(ArrayList<Order> ol) {
        displayOrderList(ol);
        System.out.print("Enter name: ");
        String name = validation.getString();
        orderList.put(name, ol);
        System.err.println("Added successfully!");
    }

    public void displayOrderList(ArrayList<Order> OL) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Order x : OL) {
            System.out.println(x.getFruitName() + "\t\t" + x.getQuantity() + "\t\t" + x.getPrice() + "\t\t" + x.getQuantity());
            total += x.getPrice()*x.getQuantity();
        }
        System.out.println("Total: " + total);
    }

}
