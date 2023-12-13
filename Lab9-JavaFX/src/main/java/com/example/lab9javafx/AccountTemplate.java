package com.example.lab9javafx;

public class AccountTemplate {
    private final String email;
    private final String username;
    private final String password;

    public AccountTemplate(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Hi, I am " + username + "\nmy email is " + email + "\nand my password is " + password;
    }
}
