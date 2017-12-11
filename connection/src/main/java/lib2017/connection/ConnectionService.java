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
import lib2017.connection.impl.ConnectionServiceDefaultImpl;
import lib2017.model.MyBook;
import lib2017.protocol.AbstractLibCommand;
import lib2017.utils.LibException;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author danecek
 */
public abstract class ConnectionService {

    /**
     * @param aBc the bc to set
     */
    public static void setBc(BundleContext aBc) {
        bc = aBc;
    }

    private static BundleContext bc;

    /**
     * @return the instance
     */
    public static ConnectionService service() {
        if (instance == null) {
            ServiceTracker st = new ServiceTracker(bc, ConnectionService.class, null);
            st.open();
            instance = (ConnectionService) st.getService();
            if (instance == null) {
                instance = new ConnectionServiceDefaultImpl();
            }
        }
        return instance;
    }

    private static ConnectionService instance;

    ObjectOutputStream oos;
    ObjectInputStream ois;
    boolean isConnected = false;
    static Class[] classes = {MyBook.class};

    public abstract void connect(String host, int port) throws LibException;

    public abstract <T> T sendCommand(AbstractLibCommand comm) throws LibException;
    private static final Logger LOG = Logger.getLogger(ConnectionService.class.getName());

    public abstract void disconnect();
}
