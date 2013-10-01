/*
 * DayTimeClient.java
 *
 * Created on 24 September 2007, 12:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package simpleserversconcurrent;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class EchoClient {

    /**
     * Creates a new instance of DayTimeClient
     */
    public EchoClient() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7);

            // nice output
            OutputStream os = socket.getOutputStream();
            PrintWriter toServer = new PrintWriter(os);

            // nice reading
            InputStream is = socket.getInputStream();
            Scanner fromServer = new Scanner(is);


            // to server
            String text = "some text to be echoed";
            toServer.println(text);
            toServer.flush();

            // echo from server
            while (fromServer.hasNextLine()) {
                System.out.println(fromServer.nextLine());
            }

            socket.close();
        } catch (IOException ioe) {
            System.err.println("ERROR " + ioe.toString());
        }

    }
}
