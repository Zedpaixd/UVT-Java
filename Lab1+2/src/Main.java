public class Main {
    public static void main(String[] args) {



//    LabNotes LN = new LabNotes();
//
//    LN.run();

        // LAB 1 //

        InputDevice ID = new InputDevice();
        OutputDevice OD = new OutputDevice();
        Application application = new Application(ID, OD);
        application.run();


        // LAB 2 //

        for (String temp : args) {
            if (temp.equals("words")) {
                application.wordHistogram(application.ID.getLine());
            } else if (temp.equals("numbers")) {
                application.randomArraySort(application.ID.getNumbers(15));
            } else if (temp.equals("play") /* and if next argument is ...*/) {
                System.out.println("your implementation");
            }
        }

    }
}