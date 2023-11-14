package org.example;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonMagic {

    public static <E,J>  JSONObject GenericJSONObject(E[] keys, J[] values){

        JSONObject jsonFile = new JSONObject();
        for (int i = 0; i < Math.min(keys.length, values.length); i++) {
            jsonFile.put((String) keys[i],values[i]);   // first has to be a string
        }

        return jsonFile;
    }

    public static <E,J>  JSONObject GenericJSONObject(ArrayList<E> keys, ArrayList<J> values){

        JSONObject jsonFile = new JSONObject();
        for (int i = 0; i < Math.min(keys.size(), values.size()); i++) {
            jsonFile.put((String) keys.get(i),values.get(i));   // first has to be a string
        }

        return jsonFile;
    }

    public static <E,J> JSONObject GenericJSONObject(HashMap<E,J> map){

        JSONObject jsonFile = new JSONObject(map);

        return jsonFile;

    }

    public static <E> JSONArray GenericJSONArray(E[] data){

        JSONArray jsonFile = new JSONArray(data);

        return jsonFile;

    }

    public static <E> JSONArray GenericJSONArray(ArrayList<E> data){

        JSONArray jsonFile = new JSONArray(data);

        return jsonFile;

    }

    // Throws error: Can not convert HashMap into Array-Type

//    public static <E,J> void GenericJSONArray(HashMap<E,J> hm){
//
//        JSONArray jsonFile = new JSONArray(hm);
//
//        System.out.println(jsonFile);
//
//    }

    public static void GenericJSONTokener(String data){

        JSONTokener tokener = new JSONTokener(data);

        while (tokener.more()){
            System.out.println(tokener.next());
        }

    }

    public static JSONArray GenericCommaDelimitedToJSON(String data){

        JSONArray result = CDL.toJSONArray(data);

        return result;

    }

}
