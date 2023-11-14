package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {

        DataCreator sampleData = new DataCreator();

        Integer[] sampleArrayInt = sampleData.getData(15, DataCreator.Type.Array, DataCreator.SubType.Integer);

        HashMap<Integer,String> hm = sampleData.getData(100, DataCreator.Type.HashMap, DataCreator.SubType.String);

//        JsonMagic.GenericJSONTokener("hello world");

        JsonMagic.GenericCommaDelimitedToJSON("name, city, age \n" +
                                                   "john, chicago, 22\n" +
                                                   "gary, florida, 35\n" +
                                                   "sal, vegas, 18");

        StorageClass.saveToFile("file.json",JsonMagic.GenericJSONObject(hm),false);
        StorageClass.saveToFile("file2.json",JsonMagic.GenericJSONArray(sampleArrayInt),false);

        StorageClass.saveToObjectOutputStream("file.txt",JsonMagic.GenericJSONObject(hm),false);


    }
}
