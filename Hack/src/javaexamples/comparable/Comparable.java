package javaexamples.comparable;

import java.util.Arrays;

/**
 * Created by GPrabhu on 4/11/2015.
 */
public class Comparable {

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        Fruit apple = new Fruit("Apple", "apple desc", 70);
        Fruit orange = new Fruit("Orange", "Oranage desc", 100);
        Fruit grape = new Fruit("Grape", "Grape desc", 110);
        Fruit banana = new Fruit("Banana", "banana desc", 80);

        fruits[0] = apple;
        fruits[1] = orange;
        fruits[2] = grape;
        fruits[3] = banana;

        Arrays.sort(fruits,Fruit.fruitComparator);//sort fruits based on name
        Arrays.asList(fruits).forEach(x -> System.out.println(x.getFruitName() + " " + x.getQuantity()));
        System.out.println("\n");
        Arrays.sort(fruits);//sort fruits based on the quantity                                                   //
        Arrays.asList(fruits).forEach(x -> System.out.println(x.getFruitName() + " " + x.getQuantity()));
    }

}
