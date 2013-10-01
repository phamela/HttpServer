/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phamela
 */
public class SocketEcho implements Runnable {

    private Socket connectionSocket;
<<<<<<< HEAD
    private static final String ROOT_CATALOG = "C://Users//Tobias//Documents//GitHub";
=======
    private static final String ROOT_CATALOG = "C://Users//Phamela//Documents//GitHub//HttpServer"; //Declare your root catalog like it is very important that u used a back slash to locate the root folder of our project
>>>>>>> 256067c7352c761b11b7e4854c3e177993d230c8
    private static final Logger LOGGER = Logger.getLogger("TCPServer");
    public SocketEcho(Socket connection) {
        connectionSocket = connection;
    }

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "request from" + connectionSocket);
        try {
            try {
                BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(connectionSocket.getInputStream()));
                String request = inFromClient.readLine();
                LOGGER.log(Level.INFO, "request " + request);
                 String[] requestparts = request.split(" ");
                String filename = requestparts[1];
                LOGGER.log(Level.INFO, "requestparts" + filename);
                PrintStream toClient = new PrintStream(connectionSocket.getOutputStream());
                 try {
                    FileInputStream fromfile = new FileInputStream(ROOT_CATALOG + filename);
//                String response = request. toUpperCase();
                    toClient.print("HTTP/1.0 200 ok \r\n");
                    toClient.print("\r\n");
                //toClient.print("HelloWorld!");
                    copy(fromfile, toClient);
                    toClient.flush();
                } catch (FileNotFoundException ex) {

                    toClient.print("HTTP/1.0 200 ok \r\n");
                    toClient.print("\r\n");
                    toClient.printf("Error 404 : File Not Found");
                }
            
            }finally {
                connectionSocket.close();
            }
        
        } catch (Exception x) {
        }
    }
                
//                System.out.println(request);
////                String response = request. toUpperCase();
//                PrintStream toClient = new PrintStream(connectionSocket.getOutputStream());
//                toClient.print("HTTP/1.0 200 ok \r\n");
//                toClient.print("\r\n");
//                toClient.print("Hi Tobias we need you here ! WHERE");
//            } finally {
//                connectionSocket.close();
//            }
//        } catch (Exception x) {
//        }
//        
//    }
/**
 * 
 * If you want 
 * @param output
 * @throws IOException 
 */
   private static void copy(final InputStream input, final OutputStream output) throws IOException {
        final byte[] buffer = new byte[1024];
        while (true) {
            int bytesRead = input.read(buffer);
            if (bytesRead == -1) { break; }
            output.write(buffer, 0, bytesRead);
        }
    }
}
