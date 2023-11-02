package ro.uvt.p3.fruits;

public abstract class Fruit implements Comparable<Fruit>{
    public double weight;
    public double sugarContent;
    public double waterContent;
    public Color color;
    public enum Color {
        RED, YELLOW, PURPLE, GREEN, ORANGE, PINK
    }

    public Fruit(double weight, double sugarContent, double waterContent, Fruit.Color color) {
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.waterContent = waterContent;
        this.color = color;
    }

    @Override
    public int compareTo(Fruit other) {
        // First compare by weight
        if (Double.compare(this.weight, other.weight) != 0) {
            return Double.compare(this.weight, other.weight);
        }
        // If weights are equal, then compare by sugar content
        return Double.compare(this.sugarContent, other.sugarContent);
    }

    public String compareToString(Fruit other)
    {
        int comparisonResult = this.compareTo(other);
        if (comparisonResult > 0) {
            return this.getClass().getSimpleName();
        } else if (comparisonResult < 0) {
            return other.getClass().getSimpleName();
        } else {
            return "Equal";
        }
    }

}

