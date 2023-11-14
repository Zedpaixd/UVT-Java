package org.example;

import org.json.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StorageClass {

    public static void saveToFile(String filename, JSONObject data, boolean append) {
        try{
            FileWriter file = new FileWriter(filename, append);
            file.write(data.toString(5));
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(String filename, JSONArray data, boolean append) {
        try{
            FileWriter file = new FileWriter(filename, append);
            JSONObject temp = new JSONObject();
            temp.put("Array Items", data);
            file.write(temp.toString(5));
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToObjectOutputStream(String filename, JSONObject data, boolean append){

        // When using ObjectOutputStream you make binary
        // serialization of your object. You aren't supposed
        // to view the file as a "text file" at all.

        try{
            FileOutputStream fileStream = new FileOutputStream(filename, append);
            ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
            objStream.write(data.toString().getBytes());
            objStream.close();
            fileStream.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }


}
