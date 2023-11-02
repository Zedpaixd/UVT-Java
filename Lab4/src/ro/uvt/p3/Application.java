package ro.uvt.p3;

import ro.uvt.p3.fruits.*;
import ro.uvt.p3.io.InputDevice;
import ro.uvt.p3.io.OutputDevice;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {

    private InputDevice id;
    private OutputDevice od;


    public Application(InputDevice id, OutputDevice od) {
        this.id = id;
        this.od = od;
    }

    public double computeWeight(Fruit[] fruits) {
        double totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.weight;
        }
        return totalWeight;
    }

    public double computeWeight(Collection<Fruit> fruits) {
        double totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.weight;
        }
        return totalWeight;
    }

    public double computeSugarContent(Fruit[] fruits) {
        double totalSugarContent = 0;
        for (Fruit fruit : fruits) {
            totalSugarContent += fruit.sugarContent;
        }
        return totalSugarContent;
    }

    public double computeSugarContent(Collection<Fruit> fruits) {
        double totalSugarContent = 0;
        for (Fruit fruit : fruits) {
            totalSugarContent += fruit.sugarContent;
        }
        return totalSugarContent;
    }

    public void prepareFruit(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
            if (fruit instanceof Peelable) {
                ((Peelable) fruit).peelOff();
            }

            if (fruit instanceof SeedRemovable) {
                ((SeedRemovable) fruit).removeSeeds();
                }
            }
    }

    public HashMap<String,Integer> countFruit(List<Fruit> fruits){
        HashMap<String,Integer> counter = new HashMap<>();

        for(Fruit fruit: fruits)
        {
            String classOfFruit = fruit.getClass().getSimpleName();

            // getClass => The class that extends "fruit"
            // getName => ro.uvt.p3.fruits.Banana, ro.uvt.p3.fruits.Apple, etc.
            // getSimpleName => Banana, Apple, etc.

            counter.put(classOfFruit,
                        counter.getOrDefault(classOfFruit,0)+1);

            // counter.put => inserts value into hashmap
            // counter.getOrDefault => tries to find the value and return it
            //                         if it does not exist, it returns 0
        }



        return counter;
    }

    public void testFruitComparison(List<Fruit> fruits){

        // Here we will be sorting by the logic
        // of compareTo defined in Fruit
        // In order to compare, we always need to implement Comparable

        Collections.sort(fruits);

        Fruit minFruit = Collections.min(fruits);
        Fruit maxFruit = Collections.max(fruits);

        System.out.println("Fruits after sorting:");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.getClass().getSimpleName() + " - Weight: " + fruit.weight + ", SugarContent: " + fruit.sugarContent);
        }

        System.out.println("Minimum (by natural ordering): " + minFruit.getClass().getSimpleName());
        System.out.println("Maximum (by natural ordering): " + maxFruit.getClass().getSimpleName());
    }

    public String mostBoughtFruit(Collection<Fruit> fruits) {
        if (fruits.isEmpty()) return "Empty Basket";

        HashMap<Class<? extends Fruit>,Integer> frequencyMap = new HashMap<>();
        Fruit mostPopular = null;  // must initialize it
        int mostOcc = 0;

        for (Fruit fruit : fruits) {
            int frequency = frequencyMap.getOrDefault(fruit.getClass(), 0) + 1;
            frequencyMap.put(fruit.getClass(), frequency);

            if (frequency > mostOcc) {
                mostOcc = frequency;
                mostPopular = fruit;
            }
        }
        return mostPopular.getClass().getSimpleName();
    }


    public void run(){

        Banana banana = new Banana(120, 20, 75);
        Apple redApple = new Apple(150, 18, 80, Fruit.Color.RED);
        Apple greenApple = new Apple(160, 19, 82, Fruit.Color.GREEN);
        Mango mango = new Mango(200, 30, 70);

        FruitProcessor fp = new FruitProcessor();

        List<Fruit> fruits = id.readFruitList();

//        System.out.println(computeSugarContent(fruits));
//        System.out.println(computeSugarContent(id.readFruit()));
//
//        System.out.println(countFruit(fruits));
//
//        System.out.println(banana.compareTo(greenApple));
//        System.out.println(mango.compareToString(greenApple));
//
//        testFruitComparison(fruits);
//
//        System.out.println(mostBoughtFruit(fruits));

        // Filter fruits with sugar content less than or equal to 20
        List<Fruit> lowSugarFruits = fp.filterFruitsWithHighSugar(fruits);
        System.out.println("Filtered fruits (sugar <= 20): " + lowSugarFruits.size());

        System.out.println("Total sugar content: " + fp.sumOfSugarContent(fruits));

        System.out.println("Sugar/Water ratios: " + fp.computeSugarWaterRatio(fruits));
    }

}

