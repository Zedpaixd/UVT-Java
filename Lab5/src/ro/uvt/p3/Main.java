package ro.uvt.p3;

import ro.uvt.p3.io.FileOperations;
import ro.uvt.p3.io.InputDevice;
import ro.uvt.p3.io.OutputDevice;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputDevice id = new InputDevice(System.in);
        OutputDevice od = new OutputDevice(System.out);
//
//        FileInputStream FIS = new FileInputStream("file.txt");
//        FileOutputStream FOS = new FileOutputStream("file.txt",true);
//        InputDevice id = new InputDevice(FIS);
//        OutputDevice od = new OutputDevice(FOS);

//        Application app = new Application(id, od);
//        Playground pg = new Playground();

//        od.writeBytes("Project presentations in 2 weeks\n".getBytes());
//        od.writeToFile("hello there\n","file.txt",true);
        id.testRead();



//        FileOperations.writeRandomNumbers();
//        FileOperations.askUserForFile();

//        pg.run();
//        app.run();

//        FIS.close();
//        FOS.close();
    }
}
