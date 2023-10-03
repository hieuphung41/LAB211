package J1SP0023;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        FruitList FL = new FruitList();
        OrderList OL = new OrderList();
        Validation validation = new Validation();
        while (true) {
            menu();
            System.out.print("> Your choice: ");
            int choice = validation.getIntInRange(1, 4);
            switch (choice) {
                case 1:
                    while (true) {
                        Fruit fruit = new Fruit();
                        fruit.createFruit();
                        FL.addFruit(fruit);
                        System.err.println("Added successfully!");
                        System.out.println("Do you want to continue (Y/N)? ");
                        if (!validation.getYN()) {
                            break;
                        }
                    }
                    break;
                case 2:
                    if (OL.orderList.isEmpty()) {
                        System.err.println("No order!");
                    } else {
                        OL.displayOrders();
                    }
                    break;
                case 3:
                    if (FL.fruitList.isEmpty()) {
                        System.err.println("No fruit!");
                        break;
                    }
                    int id;
                    ArrayList<Order> ol = new ArrayList<>();
                    while (true) {
                        if (FL.fruitList.isEmpty()) {
                            System.err.println("No fruit!");
                            break;
                        }
                        FL.displayFruits();
                        System.out.print("Select item to buy: ");
                        id = validation.getInt();
                        Fruit fruit = FL.getFruit(id);
                        if (fruit != null) {
                            Order order = new Order();
                            System.out.println("You selected: " + fruit.getFruitName());
                            System.out.print("Please input quantity: ");
                            int quantity = validation.getIntInRange(0, fruit.getQuantity());
                            order.createOrder(fruit, quantity);
                            ol.add(order);
                            if ((fruit.getQuantity() - quantity) == 0) {
                                FL.removeFruit(fruit);
                            } else {
                                fruit.setQuantity(fruit.getQuantity() - quantity);
                            }
                            System.out.println("Do you want to continue (Y/N)? ");
                            if (!validation.getYN()) {
                                break;
                            }
                        } else {
                            System.err.println("Invalid id!");
                        }
                    }
                    OL.shopping(ol);

                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("\t1. Create fruit");
        System.out.println("\t2. View order");
        System.out.println("\t3. Shopping (for buyer)");
        System.out.println("\t4. Exit");
    }

}