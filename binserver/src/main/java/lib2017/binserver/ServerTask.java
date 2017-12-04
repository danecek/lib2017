/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.binserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ServerTask implements Runnable {
    
    private ExecutorService es;
    
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(3333);
            for (;;) {                
                LOG.info("waiting for client");
                Socket s = ss.accept();
                es.submit(new ClientTask(s));                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final Logger LOG = Logger.getLogger(ServerTask.class.getName());
    
    public ServerTask(ExecutorService es) {
        this.es = es;
    }
    
}
