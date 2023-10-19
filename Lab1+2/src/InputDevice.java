import java.util.ArrayList;
import java.util.Random;

public class InputDevice {

    // LAB 1 //

    public String getType(){
        return "random";
    }
    public Integer nextInt()
    {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1,100);
    }

    // LAB 2 //
    // import java.util.ArrayList; !
    public ArrayList<Integer> getNumbers(int N){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i<N; i++) {
            temp.add(this.nextInt());
        }

        return temp;
    }

    public String getLine(){
        return "The quick brown fox jumps over the lazy dog";
    }

}
