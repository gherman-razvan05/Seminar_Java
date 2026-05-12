package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InteractiveTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter serverOut = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Conectat! Scrie ceva sau așteaptă mesaje...");

        while (true) {
            if (serverIn.ready()) {
                String response = serverIn.readLine();
                System.out.println("\n" + response);
            }

            if (userInput.ready()) {
                String userMessage = userInput.readLine();
                if (userMessage.equalsIgnoreCase("exit")) break;
                serverOut.println(userMessage);
            }

        }
        socket.close();
    }
}
