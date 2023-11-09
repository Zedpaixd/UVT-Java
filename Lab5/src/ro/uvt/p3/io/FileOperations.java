package ro.uvt.p3.io;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileOperations {

    public static void askUserForFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a file name to read:");
            String fileName = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            } catch (IOException e) {
                System.out.println("Could not open file. Please try again.");
            }
        }
    }

    public static void writeRandomNumbers() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a file name to write random numbers:");
            String fileName = scanner.nextLine();
            try (FileWriter writer = new FileWriter(fileName)) {
                for (int i = 0; i < 10; i++) {
                    writer.write(random.nextInt(100) + "\n"); // Writes random numbers between 0 and 99
                }
                break;
            } catch (IOException e) {
                System.out.println("Could not open file. Please try again.");
            }
        }
    }
}