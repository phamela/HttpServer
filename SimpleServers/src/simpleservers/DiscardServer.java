/*
 * DayTimeServer.java
 */
package simpleservers;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class DiscardServer {

    private static final int PORT = 9;

    /**
     * Creates a new instance of DayTimeServer
     */
    public DiscardServer() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(PORT);

            while (true) {
                Socket clientSocket = serverSock.accept();

                // nice reading
                InputStream is = clientSocket.getInputStream();
                Scanner fromClient = new Scanner(is);

                // no output
                
                // echo text
                String discardString = "";
                if (fromClient.hasNextLine()) {
                    discardString = fromClient.nextLine();
                }

                System.out.println("SERVER text to discard :" + discardString + ":");

                clientSocket.close();
            }
        } catch (IOException ioe) {
            System.err.println("ERROR " + ioe.toString());
        }
    }
}
