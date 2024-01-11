package com.example.lab9javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.HashMap;

public class Register_Controller {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;

    @FXML
    private Button registerButton;
    @FXML
    private Button changeScreenButton;


    @FXML
    protected void onRegisterClick() {

        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || emailField.getText().isEmpty()) {
            errorLabel.setText("Fields can not be left empty!");
            return;
        }

        errorLabel.setText("");

        Accounts.addAccount(new AccountTemplate(emailField.getText(),
                                                usernameField.getText(),
                                                Encryption.Encrypt(passwordField.getText(),"Lab9")));

        Accounts.printAccounts();
    }

    @FXML
    protected void onChangeToLogInClick(){
        ScreenController.activate("LogIn");
    }


}