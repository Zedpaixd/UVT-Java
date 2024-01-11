package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;

public class ChatServer {

    private static final int PORT = 1234;
    private static Set<PrintWriter> writers = new HashSet<>();
    private static AtomicInteger clientIdCounter = new AtomicInteger(1);

    public static void main(String[] args) throws IOException {
        System.out.println("Server is running");

        ServerSocket listener = new ServerSocket(PORT);

        try {
            while(true){
                new Handler(listener.accept()).start();
            }
        }
        finally {
                listener.close();
            }

        }


    private static class Handler extends Thread{
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientId;

        private Handler(Socket socket){
            this.socket = socket;
            this.clientId = "User-" + clientIdCounter.getAndIncrement();
        }

        public void run(){
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                writers.add(out);

                while(true){
                    String input = in.readLine();
                    if (input == null){
                        return;
                    }
                    for (PrintWriter writer : writers){
                        writer.println(this.clientId + " wrote : " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null){
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}