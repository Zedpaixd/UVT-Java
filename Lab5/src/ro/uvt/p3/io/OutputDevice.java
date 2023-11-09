package ro.uvt.p3.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class OutputDevice {

    private final OutputStream outputStream;

    public OutputDevice(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public <E> void print(E msg) {
        System.out.println(msg);
    }

    public void writeBytes(byte[] bytes) {
        try{
            outputStream.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeToFile(String content, String fileName, Boolean append) throws IOException {
        FileWriter file = new FileWriter(fileName,append);
        file.write(content);
        file.close();
    }
}
