package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DataCreator {

    public enum Type {ArrayList, HashMap, Array}
    public enum SubType {String, Integer, Boolean}

    // Interface for data generation
    public interface DataGenerator<E> {
        E generateData(int amountOfData);
    }

    // ArrayList Generators
    public static class ArrayListStringGenerator implements DataGenerator<ArrayList<String>> {
        public ArrayList<String> generateData(int amountOfData) {
            ArrayList<String> data = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.add("String" + random.nextInt(100)); // Simplified example of random string
            }
            return data;
        }
    }

    public static class ArrayListIntegerGenerator implements DataGenerator<ArrayList<Integer>> {
        public ArrayList<Integer> generateData(int amountOfData) {
            ArrayList<Integer> data = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.add(random.nextInt());
            }
            return data;
        }
    }

    public static class ArrayListBooleanGenerator implements DataGenerator<ArrayList<Boolean>> {
        public ArrayList<Boolean> generateData(int amountOfData) {
            ArrayList<Boolean> data = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.add(random.nextBoolean());
            }
            return data;
        }
    }

    // HashMap Generators (assuming simple key-value pairs for demonstration)
    public static class HashMapStringGenerator implements DataGenerator<HashMap<Integer, String>> {
        public HashMap<Integer, String> generateData(int amountOfData) {
            HashMap<Integer, String> data = new HashMap<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.put(i, "String" + random.nextInt(100));
            }
            return data;
        }
    }

    public static class HashMapIntegerGenerator implements DataGenerator<HashMap<Integer, Integer>> {
        public HashMap<Integer, Integer> generateData(int amountOfData) {
            HashMap<Integer, Integer> data = new HashMap<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.put(i, random.nextInt(100));
            }
            return data;
        }
    }

    public static class HashMapBooleanGenerator implements DataGenerator<HashMap<Integer, Boolean>> {
        public HashMap<Integer, Boolean> generateData(int amountOfData) {
            HashMap<Integer, Boolean> data = new HashMap<>();
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data.put(i, random.nextBoolean());
            }
            return data;
        }
    }

    // Array Generators
    public static class ArrayStringGenerator implements DataGenerator<String[]> {
        public String[] generateData(int amountOfData) {
            String[] data = new String[amountOfData];
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data[i] = "String" + random.nextInt(100);
            }
            return data;
        }
    }

    public static class ArrayIntegerGenerator implements DataGenerator<Integer[]> {
        public Integer[] generateData(int amountOfData) {
            Integer[] data = new Integer[amountOfData];
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data[i] = random.nextInt(100);
            }
            return data;
        }
    }

    public static class ArrayBooleanGenerator implements DataGenerator<Boolean[]> {
        public Boolean[] generateData(int amountOfData) {
            Boolean[] data = new Boolean[amountOfData];
            Random random = new Random();
            for (int i = 0; i < amountOfData; i++) {
                data[i] = random.nextBoolean();
            }
            return data;
        }
    }

    // Factory class
    public static class DataGeneratorFactory {
        public static DataGenerator<?> getDataGenerator(Type dataType, SubType dataSubType) {
            return switch (dataType) {
                case ArrayList -> switch (dataSubType) {
                    case String -> new ArrayListStringGenerator();
                    case Integer -> new ArrayListIntegerGenerator();
                    case Boolean -> new ArrayListBooleanGenerator();
                };
                case HashMap -> switch (dataSubType) {
                    case String -> new HashMapStringGenerator();
                    case Integer -> new HashMapIntegerGenerator();
                    case Boolean -> new HashMapBooleanGenerator();
                };
                case Array -> switch (dataSubType) {
                    case String -> new ArrayStringGenerator();
                    case Integer -> new ArrayIntegerGenerator();
                    case Boolean -> new ArrayBooleanGenerator();
                };
                //
            };
        }
    }

    // Method to get data
    public <E> E getData(int amountOfData, Type dataType, SubType dataSubType) {
        DataGenerator<E> generator = (DataGenerator<E>) DataGeneratorFactory.getDataGenerator(dataType, dataSubType);
        return generator.generateData(amountOfData);
    }
}
