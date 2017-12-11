/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.connection.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib2017.business.Books;
import lib2017.connection.ConnectionService;
import lib2017.model.MyBook;
import lib2017.protocol.AbstractLibCommand;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class ConnectionServiceDefaultImpl extends ConnectionService {

    public static final ConnectionServiceDefaultImpl instance = new ConnectionServiceDefaultImpl();

    ObjectOutputStream oos;
    ObjectInputStream ois;
    boolean isConnected = false;
    static Class[] classes = {MyBook.class, Books.class};

    @Override
    public void connect(String host, int port) throws LibException {
        try {
            LOG.log(Level.INFO, "{0}:{1}", new Object[]{host, port});
            Socket s = new Socket(host, port);

            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            isConnected = true;
        } catch (IOException ex) {
            throw new LibException(ex);
        }
    }

    @Override
    public <T> T sendCommand(AbstractLibCommand comm) throws LibException {

        if (!isConnected) {
            throw new LibException("not connected");
        }
        try {
            LOG.info(comm.toString());
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
            Logger.getLogger(ConnectionServiceDefaultImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(ConnectionServiceDefaultImpl.class.getName());

    public void disconnect() {
        isConnected = false;
    }
}
