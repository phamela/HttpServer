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
public class DayTimeServer {
    
    private static final int PORT = 13;
    
    /** Creates a new instance of DayTimeServer */
    public DayTimeServer() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(PORT);

            while (true) {
                Socket clientSocket = serverSock.accept();

                // no input for daytime server
                
                // nice output
                OutputStream os = clientSocket.getOutputStream();
                PrintWriter toClient = new PrintWriter(os);  // 

                // echo text
                String daytime = new Date().toString();
                System.out.println("Server daytime string :" + daytime + ":");
                toClient.println(daytime);
                toClient.flush();
                
                clientSocket.close();
            }
        } catch (IOException ioe) {
            System.err.println("ERROR " + ioe.toString());
        }
    }
}
