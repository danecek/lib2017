/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib2017.protocol.AbstractLibCommand;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class Connection {

    public static final Connection instance = new Connection();

    ObjectOutputStream oos;
    ObjectInputStream ois;

    public void connect(String host, int port) throws LibException {
        try {
            Socket s = new Socket(host, port);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            throw new LibException(ex);
        }

    }

    public <T> T sendCommand(AbstractLibCommand comm) throws LibException {
        try {
            oos.writeObject(comm);
            oos.flush();
            Object result = ois.readObject();
            if (result instanceof LibException) {
                throw (LibException) result;
            }
            return (T) result;

        } catch (IOException ex) {
            throw new LibException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

    public void disconnect() {

    }
}
