package J1SP0023;

import java.util.ArrayList;
import java.util.Collections;

public class FruitList {

    ArrayList<Fruit> fruitList = new ArrayList<>();

    public void addFruit(Fruit fruit) {
        Fruit newFruit = checkDupliatedFruit(fruit);
        if (newFruit != null) {
            for (Fruit x : fruitList) {
                if (x.getFruitID() == newFruit.getFruitID() && x.getFruitName().equals(newFruit.getFruitName())) {
                    x.setQuantity(x.getQuantity() + newFruit.getQuantity());
                    x.setPrice(newFruit.getPrice());
                }
            }
        } else {
            fruitList.add(fruit);
        }
        displayFruits();
    }

    public void displayFruits() {
        System.out.println("| ++ Item ++ | ++ Fruit name ++ | ++ Origin ++ | ++ Price ++ ");
        sortList();
        fruitList.forEach((x) -> {
            System.out.println(x.getFruitID() + "\t\t" + x.getFruitName() + "\t\t" + x.getOrigin() + "\t\t" + x.getPrice());
        });
    }

    public void sortList() {
        Collections.sort(fruitList, (Fruit o1, Fruit o2) -> {
            if (o1.getFruitID() < o2.getFruitID()) {
                return -1;
            } else if (o1.getFruitID() > o2.getFruitID()) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    private Fruit checkDupliatedFruit(Fruit fruit) {
        for (Fruit x : fruitList) {
            if (x.getFruitID() == fruit.getFruitID() && x.getFruitName().equals(fruit.getFruitName())) {
                return x;
            }
        }
        return null;
    }

    public Fruit getFruit(int id) {
        for (Fruit x : fruitList) {
            if (x.getFruitID() == id) {
                return x;
            }
        }
        return null;
    }

    public void removeFruit(Fruit fruit) {
        fruitList.remove(fruit);
    }
}
