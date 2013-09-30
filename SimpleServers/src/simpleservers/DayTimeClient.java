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
public class DayTimeClient {
    
    /** Creates a new instance of DayTimeClient */
    public DayTimeClient() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 13);

            // no output
           
            // nice reading
            InputStream is = socket.getInputStream();
            Scanner fromServer = new Scanner(is);


            // day and time from server
            while (fromServer.hasNextLine()){
                System.out.println(fromServer.nextLine());
            }

            socket.close();
        }catch(IOException ioe){
            System.err.println("ERROR " + ioe.toString());
        }
    }
}
