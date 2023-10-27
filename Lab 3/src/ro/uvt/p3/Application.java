package ro.uvt.p3;

import ro.uvt.p3.fruits.*;
import ro.uvt.p3.io.InputDevice;
import ro.uvt.p3.io.OutputDevice;

public class Application {

    private InputDevice id;
    private OutputDevice od;


    public Application(InputDevice id, OutputDevice od) {
        this.id = id;
        this.od = od;
    }

    public static double computeWeight(Fruit[] fruits) {
        double totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.weight;
        }
        return totalWeight;
    }

    public static double computeSugarContent(Fruit[] fruits) {
        double totalSugarContent = 0;
        for (Fruit fruit : fruits) {
            totalSugarContent += fruit.sugarContent;
        }
        return totalSugarContent;
    }

    public static void prepareFruit(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
            if (fruit instanceof Peelable) {
                ((Peelable) fruit).peelOff();
            }

            if (fruit instanceof SeedRemovable) {
                ((SeedRemovable) fruit).removeSeeds();
                }
            }
    }


    public void run(){

        Banana banana = new Banana(120, 20, 75);
        Apple redApple = new Apple(150, 18, 80, Fruit.Color.RED);
        Apple greenApple = new Apple(160, 19, 82, Fruit.Color.GREEN);

//        System.out.println(banana.toString());

        System.out.println(computeWeight(id.readFruit()));
        System.out.println(computeSugarContent(id.readFruit()));
        prepareFruit(id.readFruit());


        
    }
}
