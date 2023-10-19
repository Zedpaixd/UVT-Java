import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;

public class LabNotes {

    // Lab 2

    /*
                                 Arrays


     Sets, Queues, Iterators
     --- popular interfaces

     ArrayLists -  HashMaps - LinkedList
     --- most popular storage ways

     Useful import: "Collections"
     --- utility methods such as .sort() .binarySearch()



                                Strings

    Main operations:
    splitting and comparing



                                CLI arguments

    What are they? How to use them?

    public static void main(String[] args)



                               Extra trick:

                  Java imports are like namespaces in C++
                         (example shown later on)

                         Difficult task of this week:

     WordHistogram:
     Take a sentence and convert it into a
     histogram that shows how many words of
     length n are.

     Collection to use: ArrayList

     Better alternative: HashMap

     Step by step process:

     1. ...?




                    Tasks:

    1. Implement a function getNumbers(int N)
       in Input Device which returns an array of
       N randomly generated numbers between
       1 and 100.


    2. Implement a function sortNumbers in
       Application which can sort an array
       of integers received as argument,
       in place. (in place = ?)


    3. Test the implementations in a new
       function randomArraySort

       public void randomArraySort(ArrayList<Integer> ToSort){
            System.out.println("Before:" + ToSort);
            SortNumbers(ToSort);
            System.out.println("After:" + ToSort);
        }

    4. Implement a function getLine() in
       Input Device which returns a string
       representing a sentence
(e.g. “The quick brown fox jumps over the lazy dog.”).

    5. Implement a function wordSizeHistogram
       in Application which takes as argument
       a string representing a sentence and
       returns an array of integers representing
       the histogram of the word size. For the
       above example, we have 4 words of length 3
       (The, fox, the, dog) so on position 3 we
       will have value 4, and so on.

    6. Test the implementations in a new function
       exampleHistogram in class Main


    7. Refactor the main method to print all
       program arguments, using the OutputDevice.

    8. Adapt the main function and the Application
       class to meet the following requirements:

        (a) if the first argument is words,
            then the program should run the
            exampleHistogram function.

        (b) if the first argument is numbers,
            the program should run the
            randomArraySort function.

        (c) if the first argument is play,
        then the second argument is a number
        representing the number of rounds to
        win until the game (Lab 1.4) ends.

    Caution! The program argument is String, and must
            be transformed into an integer.



     */

    public void run(){

        System.out.println("Lab 2");

        ArrayList<String> al = new ArrayList<>();
//        al.get(i) -> Gets element at index i
//        al.add(e) -> Adds element e at first available index
//        al.size() -> Returns length of this ArrayList
//        al.remove(element/index) -> Removes either specified element or index
//        al.set(x,v) -> Sets element at index x to value v

        Integer someInt = 7;
        String sentence = "splitting a sentence into many words "
                + Integer.toString(someInt)
                + String.valueOf(someInt);
// ["splitting", "a", "sentence", "into", "many", "words", "77"]
        for (String x: sentence.split(" ")) {
            al.add(x);
        }

//        System.out.println(al);

//        java.util.Collections.sort(al);
//        Collections.sort(al);
//        System.out.println(al);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(3);
        al2.add(1);
        al2.add(9);
        Collections.sort(al2);
        System.out.println(al2);


    }


}
