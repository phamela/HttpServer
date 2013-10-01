/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Phamela
 */
public class SocketEcho implements Runnable {

    private Socket connectionSocket;

    public SocketEcho(Socket connection) {
        connectionSocket = connection;
    }

    @Override
    public void run() {
        try {
            try {
                BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(connectionSocket.getInputStream()));
                String request = inFromClient.readLine();
                System.out.println(request);
//                String response = request. toUpperCase();
                PrintStream toClient = new PrintStream(connectionSocket.getOutputStream());
                toClient.print("HTTP/1.0 200 ok \r\n");
                toClient.print("\r\n");
                toClient.print("Hi Tobias we need you here ! WHERE");
            } finally {
                connectionSocket.close();
            }
        } catch (Exception x) {
        }
    }
}
