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

    public void shopping(FruitList FL) {
        ArrayList<Order> orderArrayList = new ArrayList<>();
        // Đặt ArrayList<Order> orderArrayList vào trong hàm shopping đề ngừa trường hợp tất cả order
        // gộp chung với nhau
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
            buyFruit(FL, orderArrayList, id, quantity);
            System.out.println("Do you want to continue (Y/N)? ");
            if (!validation.getYN()) {
                break;
            }
        }
        if (orderArrayList.isEmpty()) {
            return;
        }
        display(orderArrayList);
        System.out.print("Enter name: ");
        String name = validation.getString();
        orderList.put(name, orderArrayList);
        System.err.println("Added successfully!");
    }

    public void buyFruit(FruitList fruitList, ArrayList<Order> orderArrayList, int id, int quantity) {
        Fruit fruit = fruitList.getFruit(id);
        if (fruit == null) {
            System.out.println("No fruit!");
            return;
        }
        Order order1 = getOrderByID(orderArrayList, id);
        if (order1 != null) {
            order1.setQuantity(order1.getQuantity() + quantity);
        } else {
            Order newOrder = new Order();
            newOrder.createOrder(fruit, quantity);
            orderArrayList.add(newOrder);
        }
        if ((fruit.getQuantity() - quantity) == 0) {
            fruitList.removeFruit(fruit);
        } else {
            fruit.setQuantity(fruit.getQuantity() - quantity);
        }
    }

    public Order getOrderByID(ArrayList<Order> orderArrayList, int id) {
        for (Order x : orderArrayList) {
            if (x.getFruitID() == id) {
                return x;
            }
        }
        return null;
    }

}
