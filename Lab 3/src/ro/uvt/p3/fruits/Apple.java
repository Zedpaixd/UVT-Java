package ro.uvt.p3.fruits;

// Class for Apples
public class Apple extends Fruit implements SeedRemovable {

    private boolean seedsRemoved;

    public Apple(double weight, double sugarContent, double waterContent, Color color) {
        super(weight, sugarContent, waterContent, color);
        this.seedsRemoved = false; // Initially, the apple has seeds
    }

    @Override
    public boolean hasSeeds() {
        return !seedsRemoved;
    }

    @Override
    public void removeSeeds() {
        if (!seedsRemoved) {
            seedsRemoved = true;
            System.out.println("Apple's seeds are gone");
        } else {
            System.out.println("Just eat it...");
        }
    }
}
