import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Application {

    // LAB 1 //

    InputDevice ID;
    OutputDevice OD;

    public Application(InputDevice ID, OutputDevice OD){
        this.ID = ID;
        this.OD = OD;
    }


    // LAB 2 //

    public void SortNumbers(ArrayList<Integer> ToSort){
        Collections.sort(ToSort);
    }
    
    public void randomArraySort(ArrayList<Integer> ToSort){
        System.out.println("Before:" + ToSort);
        SortNumbers(ToSort);
        System.out.println("After:" + ToSort);
    }

    public ArrayList<Integer> wordSizeHistogram(String sentence) {
        ArrayList<Integer> HashmapsAreBetter = new ArrayList<Integer>();
        int longestWordLength = 0;

        for (String word: sentence.split(" ")) {
            longestWordLength = Math.max(word.length(), longestWordLength);
        }

        for (int i = 0; i <= longestWordLength; i++) {
            HashmapsAreBetter.add(0);
        }
        for (String word: sentence.split(" ")) {
            HashmapsAreBetter.set(word.length(),HashmapsAreBetter.get(word.length()) + 1);
        }
        return HashmapsAreBetter;
    }

//    public ArrayList<Integer> wordSizeHistogram(String s) {
//        ArrayList<Integer> h = new ArrayList<>();
//        Arrays.stream(s.split(" ")).forEach(w -> {while (h.size() <= w.length()) h.add(0);h.set(w.length(), h.get(w.length()) + 1);});
//        return h;
//    }


    public void wordHistogram(String sentence)
    {
        System.out.println("Histogram of \""
                            + sentence
                            + "\" is \n"
                            + wordSizeHistogram(sentence));
    }

    public void run() {
        OD.write("Application Started!");
        OD.write(String.format("Today's lucky numbers are: %d %d",ID.nextInt(),ID.nextInt()));
    }

}
