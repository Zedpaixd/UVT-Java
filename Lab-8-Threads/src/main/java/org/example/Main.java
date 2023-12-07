package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Integer> array = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 99000; i++) {
            array.add(rand.nextInt(1,10000));
        }
        int threadCount = 4; // can increase or decrease it
        SumThread[] threads = new SumThread[threadCount];

        int chunkSize = (int) Math.ceil(array.size() / (double) threadCount);
        long totalSum = 0;
        long startTime = System.currentTimeMillis();

        // split the array evenly across all threads
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new SumThread(array, i * chunkSize, (i + 1) * chunkSize);
            threads[i].start();
        }

        // join them all together
        try {
            for (SumThread thread : threads) {
                thread.join();
                totalSum += thread.getPartialSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total sum: " + totalSum);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");


//        BankAccount account = new BankAccount("account_balance.txt");
//
//
//        account.deposit(1000);
//        // true = Deposit
//        // false = Withdraw
//        new BankClient(account, 500, true).start();
//        new BankClient(account, 200, false).start();
//        new BankClient(account, 300, true).start();



//        String literaryText = new String(Files.readAllBytes(Paths.get("literary_text.txt")));
//        List<String> words = Files.readAllLines(Paths.get("words_list.txt"));
//
//        for (String word : words) {
//            WordCountThread thread = new WordCountThread(word, literaryText);
//            thread.start();
//            thread.join(); // Wait for this thread to finish before starting the next one
//
//            // Theory time!
//            // wait() and notify() - notifyAll()
//
//            System.out.println("The word '" + word + "' appears " + thread.getCount() + " times.");
        }
    }
}