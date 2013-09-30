/*
 * EchoServer.java
 */
package simpleservers;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Peter Levinsky
 */
public class EchoServer {

    private static final int PORT = 7;
    
    /** Creates a new instance of DayTimeServer */
    public EchoServer() {
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

                // nice output
                OutputStream os = clientSocket.getOutputStream();
                PrintWriter toClient = new PrintWriter(os);  // evtually new PrintWriter(os,true) - allways flush


                // echo text
                String echoString = "No Echo";
                if (fromClient.hasNextLine()) {
                    echoString = fromClient.nextLine();
                }
                System.out.println("Echo string :" + echoString + ":");
                toClient.println(echoString);
                toClient.flush();
                
                clientSocket.close();
            }
        } catch (IOException ioe) {
            System.err.println("ERROR " + ioe.toString());
        }
    }
}
