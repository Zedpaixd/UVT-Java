package com.example.lab9javafx;

import java.util.HashMap;

public class Accounts {

    private static HashMap<Integer,AccountTemplate> accounts = new HashMap<>();

    public static void addAccount(AccountTemplate account){
       accounts.put(accounts.values().size(),account);
    }

    public static void printAccounts(){
        System.out.println(accounts.toString());
    }

    public static boolean verifyExistance(String email, String username, String password){
        for(AccountTemplate acc : accounts.values()){
            if (acc.getEmail().equals(email) && acc.getUsername().equals(username) && acc.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
