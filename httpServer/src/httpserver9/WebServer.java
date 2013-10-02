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
public class WebServer {
    public static final int SERVER_PORT = 9876;

    public WebServer(int port) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();
        ServerSocket s = new ServerSocket(port);
        while (true) {
            Socket clientConnection = s.accept();
            Runnable service = new WebServerhelper(clientConnection);
            pool.execute(service);
        }
    }

    public static void main(String[] args) throws IOException {
        new WebServer(SERVER_PORT);
    }
}
