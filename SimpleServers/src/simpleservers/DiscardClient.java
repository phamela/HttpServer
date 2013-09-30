/*
 * DayTimeClient.java
 */

package simpleservers;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DiscardClient {
    
    /** Creates a new instance of DayTimeClient */
    public DiscardClient() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Socket socket = new Socket("localhost", 9);

            // nice output
            OutputStream os = socket.getOutputStream();
            PrintWriter toServer = new PrintWriter(os);  

            // no reading
            
            // to server
            String text = "some text to be discarded";
            toServer.println(text);
            toServer.flush();

            socket.close();
        }catch(IOException ioe){
            System.err.println("ERROR " + ioe.toString());
        }
    }
}
