package javaexamples.comparable;

import java.util.Comparator;

public class Fruit implements java.lang.Comparable<Fruit> {
    public Fruit(String fruitName, String fruitDesc, int quantity) {
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
    }

    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitDesc() {
        return fruitDesc;
    }

    public void setFruitDesc(String fruitDesc) {
        this.fruitDesc = fruitDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String fruitDesc;
    private int quantity;


    @Override
    public int compareTo(Fruit fruit) {
        return fruit.getQuantity()- this.getQuantity();
    }

    public static Comparator<Fruit> fruitComparator = new Comparator<Fruit>() {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.getFruitName().compareTo(o2.getFruitName());
        }
    };
}
