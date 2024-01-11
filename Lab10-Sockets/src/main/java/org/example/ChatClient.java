package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader consoleInput;
    private static final Integer IP = 1234;

    public ChatClient(){
        consoleInput = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws IOException{
        System.out.println("Please input the IP of the server");
        String serverAddress = consoleInput.readLine();

        Socket socket = new Socket(serverAddress,IP);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        Thread readThread = new Thread(() -> {
            try{
                while (true){
                    String line = in.readLine();
                    if (line != null){
                        System.out.println("Received: " + line);
                    } else{
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        });
        readThread.start();

        String userInput;
        while ((userInput = consoleInput.readLine()) != null){
            out.println(userInput);
        }

        socket.close();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException{
        ChatClient client = new ChatClient();
        client.run();
    }
}
