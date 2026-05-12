package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcp {
    public static void main(String[] args) throws IOException {
        int port = 5001;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        Socket client1 = serverSocket.accept();
        System.out.println("Client 1 conectat!");
        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(),true);

        Socket client2 = serverSocket.accept();
        System.out.println("Client 2 conectat!");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(),true);

        String message;
        while (true) {
            if (in1.ready()) {
                message = in1.readLine();
                if (message == null) break;
                System.out.println("Clientul 1 trimite: " + message);
                out2.println("Clientul 1 spune: " + message);
            }

            if (in2.ready()) {
                message = in2.readLine();
                if (message == null) break;
                System.out.println("Client 2 trimite: " + message);
                out1.println("Clientul 2 spune: " + message);
            }
        }

        client1.close();
        client2.close();
        serverSocket.close();
    }
}
