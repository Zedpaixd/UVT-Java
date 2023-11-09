package ro.uvt.p3;

import ro.uvt.p3.fruits.Fruit;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FruitProcessor {

    public List<Fruit> filterFruitsWithHighSugar(Collection<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.sugarContent <= 20)
                .collect(Collectors.toList());
    }

    public double sumOfSugarContent(Collection<Fruit> fruits) {
        return fruits.stream()
                .mapToDouble(fruit -> fruit.sugarContent)
                .sum();
    }

    public List<Double> computeSugarWaterRatio(Collection<Fruit> fruits) {
        return fruits.stream()
                .map(fruit -> fruit.sugarContent / fruit.waterContent)
                .collect(Collectors.toList());
    }
}
