package ro.uvt.p3.io;
import ro.uvt.p3.fruits.Apple;
import ro.uvt.p3.fruits.Banana;
import ro.uvt.p3.fruits.Mango;
import ro.uvt.p3.fruits.Fruit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDevice {

    private final InputStream inputStream;

    public InputDevice(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void testRead(){
        try {

            String temp;
            if (inputStream != System.in) {
                temp = new String(inputStream.readAllBytes());
            }
            else {
                Scanner input = new Scanner(inputStream);
                temp = input.nextLine();
            }
                System.out.println("You wrote: " + temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
