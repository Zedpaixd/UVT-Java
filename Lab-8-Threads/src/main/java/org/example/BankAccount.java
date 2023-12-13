package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String filePath;
    private final ReentrantLock lock = new ReentrantLock(true); // true vs false argument --> false may result in starvation for long waiting
    // synchronized (this) { ... }

    public BankAccount(String filePath) {
        this.filePath = filePath;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            double currentBalance = readBalance();
            writeBalance(currentBalance + amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            double currentBalance = readBalance();
            writeBalance(currentBalance - amount);
        } finally {
            lock.unlock();
        }
    }

    private double readBalance() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return Double.parseDouble(content.trim());
        } catch (IOException e) {
            throw new RuntimeException("Error reading balance", e);
        }
    }

    private void writeBalance(double balance) {
        try {
            Files.write(Paths.get(filePath), String.valueOf(balance).getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error writing balance", e);
        }
    }
}
