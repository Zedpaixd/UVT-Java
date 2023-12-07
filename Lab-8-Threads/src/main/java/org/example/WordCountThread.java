package org.example;

public class WordCountThread extends Thread {
    private final String word;
    private final String text;
    private int count = 0;

    public WordCountThread(String word, String text) {
        this.word = word;
        this.text = text.toLowerCase();
    }

    @Override
    public void run() {
        count = countWordInText(word, text);
    }

    public int getCount() {
        return count;
    }

    private int countWordInText(String word, String text) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}