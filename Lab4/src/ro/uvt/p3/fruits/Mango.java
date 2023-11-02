package ro.uvt.p3.fruits;

public class Mango extends Fruit implements Peelable, SeedRemovable{

    private boolean peeledOff;
    private boolean seedsRemoved;

    public Mango(double weight, double sugarContent, double waterContent) {
        super(weight, sugarContent, waterContent, Color.ORANGE);
        this.peeledOff = false;
        this.seedsRemoved = false;
    }

    @Override
    public boolean hasPeel() {
        return !peeledOff;
    }

    @Override
    public void peelOff() {
        if (!peeledOff) {
            peeledOff = true;
            System.out.println("Mango has been peeled off.");
        } else {
            System.out.println("Mango is already peeled off.");
        }
    }

    @Override
    public boolean hasSeeds() {
        return !seedsRemoved;
    }

    @Override
    public void removeSeeds() {
        if (!seedsRemoved) {
            seedsRemoved = true;
            System.out.println("Seeds have been removed from the mango.");
        } else {
            System.out.println("Seeds are already removed from the mango.");
        }
    }
}
