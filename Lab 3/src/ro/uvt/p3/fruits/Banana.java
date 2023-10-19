package ro.uvt.p3.fruits;

// Class for Bananas
public class Banana extends Fruit implements Peelable {

    private boolean peeledOff;

    public Banana(double weight, double sugarContent, double waterContent) {
        super(weight, sugarContent, waterContent, Color.YELLOW); // Default color is yellow
        peeledOff = false;
    }

    @Override
    public boolean hasPeel() {
        return !peeledOff;
    }

    @Override
    public void peelOff() {
        if (!peeledOff) {
            peeledOff = true;
            System.out.println("Banana's peel is off");
        } else {
            System.out.println("What are you trying to peel off?");
        }
    }
}
