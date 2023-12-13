package com.example.lab9javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Lab9 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Lab9.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Lab9");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


        ScreenController.setMain(scene);
        ScreenController.addScreen("Register",FXMLLoader.load(Objects.requireNonNull(Lab9.class.getResource("register-view.fxml"))));
        ScreenController.addScreen("LogIn",FXMLLoader.load(Objects.requireNonNull(Lab9.class.getResource("login-view.fxml"))));
    }

    public static void main(String[] args) {
        launch();
    }
}