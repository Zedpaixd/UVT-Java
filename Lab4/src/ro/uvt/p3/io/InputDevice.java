package ro.uvt.p3.io;
import ro.uvt.p3.fruits.Apple;
import ro.uvt.p3.fruits.Banana;
import ro.uvt.p3.fruits.Mango;
import ro.uvt.p3.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class InputDevice {

    public String nextLine(){
        return "The quick brown fox jumps over the lazy dog.";
    }

    public Fruit[] readFruit() {
        Fruit[] fruits = {
                new Banana(120, 20, 75),
                new Apple(150, 18, 80, Fruit.Color.RED),
                new Apple(160, 19, 82, Fruit.Color.GREEN),
                new Mango(200, 30, 70)
        };
        return fruits;
    }

    public List<Fruit> readFruitList(){
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Banana(120, 20, 75));
        fruits.add(new Apple(150, 18, 80, Fruit.Color.RED));
        fruits.add(new Apple(160, 19, 82, Fruit.Color.GREEN));
        fruits.add(new Mango(200, 30, 70));
        return fruits;
    }
}
