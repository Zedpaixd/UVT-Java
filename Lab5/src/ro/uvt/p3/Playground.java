package ro.uvt.p3;

import java.util.Collection;



/*
Creating a stream:
    List<Apple> apples = ...; // imagine this is a list of apples
    Stream<Apple> stream = apples.stream();
        (think of it as putting all element in a list)

Soooooo, What can you do with a stream?

Filtering: Say you only want red apples. You can "filter" them:
        List<Apple> redApples = apples.stream()
                               .filter(apple -> apple.getColor().equals("red"))
                               .collect(Collectors.toList());

Sorting: Sort by weight
       List<Apple> sortedApples = apples.stream()
                                 .sorted(Comparator.comparing(Apple::getWeight))
                                 .collect(Collectors.toList());

Finding an item: Find heaviest
      List<Apple> heaviestApple = apples.stream()
                                      .max(Comparator.comparing(Apple::getWeight));


List<anything> name = nameOfStream.stream()                         -> here you "chain elements one after the other
                           .filter(element -> element.value >20)    -> reads as "label (element) as correct if (element) >20
                                                                                 and remove the rest from the stream"
                           .collect(Collectors.toList());           -> Collectors is a util class.
                                                                    -> reads as "take the stream and put it in a list"
            name, nameOfStream and element can be anything.


Example of a more complex stream:
LinkedHashMap<String, Integer> guessTheUse = map.entrySet()
                                                      .stream()
                                                      .sorted(Map.Entry.comparingByKey())
                                                      .collect(Collectors.toMap(
                                                          Map.Entry::getKey,
                                                          Map.Entry::getValue,
                                                          (e1, e2) -> e1,
                                                          LinkedHashMap::new));

*/


public class Playground {

    // method that takes any kind of argument
    public <E> void function(E argument) {
        System.out.println(argument);
//        System.out.println(argument.intValue() > 20);  -> ERROR!
    }

    public <E extends Integer> void functionLessGeneric(E argument) {
        System.out.println(argument);
        System.out.println(argument.intValue() > 20);
    }

    // only Number and things that extend Number (i.e. Fruit, Apple, Banana, Mango)
//    public float sum(Collection<? extends Number> elems){
//        float sum = 0;
//        for(Number x : elems){
//            sum += x.floatValue();
//        }
//        return sum;
//    }

    // only Integer and things that Integer extends (i.e. Fruit)
//    public void populate(Collection<? super Integer> elems){
//
//        for(int i =0; i < 10; i++){
//            elems.add(i);
//        }
//    }

    public void run() {
        function(23);
        function("hi");

        functionLessGeneric(23);
//        functionLessGeneric("hi"); -> ERROR!
    }
}
