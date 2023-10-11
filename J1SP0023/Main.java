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
                    OL.shopping(FL, OL);
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
