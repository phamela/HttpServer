/*
 * EchoServerHandler.java
 */
package simpleserversconcurrent;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class EchoServerHandler implements Runnable {

    private Socket clientSocket;

    /** Creates a new instance of EchoServerHandler */
    public EchoServerHandler(Socket csocket) {
        this.clientSocket = csocket;
    }

    @Override
    public void run() {
        try {
            // nice reading
            InputStream is = clientSocket.getInputStream();
            Scanner fromClient = new Scanner(is);
            // nice output
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter toClient = new PrintWriter(os, true); //allways flush

            // echo text
            String echoString = "No Echo";
            if (fromClient.hasNextLine()) {
                echoString = fromClient.nextLine();
            }
            toClient.println(echoString);
            
        } catch (IOException ex) {
            Logger.getLogger(EchoServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(EchoServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
