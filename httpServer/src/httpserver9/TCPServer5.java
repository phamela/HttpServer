/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Phamela
 */
public class TCPServer5 {

    public TCPServer5(int port) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();
        ServerSocket s = new ServerSocket(port);
        while (true) {
            Socket clientConnection = s.accept();
            Runnable service = new SocketEcho(clientConnection);
            pool.execute(service);
        }
    }

    public static void main(String[] args) throws IOException {
        new TCPServer5(9876);
    }
}
