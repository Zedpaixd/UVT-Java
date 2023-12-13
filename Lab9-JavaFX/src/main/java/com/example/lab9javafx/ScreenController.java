package com.example.lab9javafx;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {
    private static final HashMap<String, Pane> screenMap = new HashMap<>();
    private static Scene main;

    public static void setMain(Scene main){
        ScreenController.main = main;
    }

    public static void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    public static void removeScreen(String name){
        screenMap.remove(name);
    }

    public static Pane getScreen(String name){
        return screenMap.get(name);
    }

    public static void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}