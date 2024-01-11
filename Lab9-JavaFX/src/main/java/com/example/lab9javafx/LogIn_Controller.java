package com.example.lab9javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class LogIn_Controller {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;

    @FXML
    private Button logInButton;
    @FXML
    private Button changeScreenButton;


    @FXML
    protected void onLogInClick() {

        if(Accounts.verifyExistance(emailField.getText(),usernameField.getText(),Encryption.Encrypt(passwordField.getText(),"Lab9"))) {
            errorLabel.setText("Log In Successful!");
            errorLabel.setTextFill(Color.GREEN);
//            ScreenController.activate("");
        } else {
            errorLabel.setText("Account does not exist.");
            errorLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    protected void onChangeToRegisterClick(){
        ScreenController.activate("Register");
    }
}
