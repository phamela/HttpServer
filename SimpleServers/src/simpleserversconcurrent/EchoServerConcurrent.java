/*
 * DayTimeServer.java
 *
 * Created on 24 September 2007, 12:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package simpleserversconcurrent;


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class EchoServerConcurrent {
    
    /** Creates a new instance of DayTimeServer */
    public EchoServerConcurrent() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket serverSock = new ServerSocket(7);
            while (true) {
                Socket clientSock = serverSock.accept();
                
                // handle request in a single thread
                EchoServerHandler esh = new EchoServerHandler(clientSock);
                new Thread(esh).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(EchoServerConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
