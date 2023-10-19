package ro.uvt.p3.fruits;

public abstract class Fruit {
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

}

