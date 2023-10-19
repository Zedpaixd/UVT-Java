package ro.uvt.p3.io;
import ro.uvt.p3.fruits.Apple;
import ro.uvt.p3.fruits.Banana;
import ro.uvt.p3.fruits.Mango;
import ro.uvt.p3.fruits.Fruit;

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
}
