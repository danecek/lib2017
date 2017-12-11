/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.connectionText;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lib2017.business.Books;
import lib2017.connection.ConnectionService;
import lib2017.model.MyBook;
import lib2017.protocol.AbstractLibCommand;
import lib2017.protocol.AllBooksCommand;
import lib2017.protocol.CreateBookCommand;
import lib2017.protocol.LogoutCommand;
import lib2017.utils.LibException;

public class ConnectionServiceTextImpl extends ConnectionService {

    public static final ConnectionServiceTextImpl instance = new ConnectionServiceTextImpl();

    OutputStream oos;
    InputStream ois;
    boolean isConnected = false;
    static Class[] classes = {MyBook.class, Books.class};
    private Unmarshaller um;
    private Marshaller m;

    @Override
    public void connect(String host, int port) throws LibException {

        try {
            JAXBContext jxbc = JAXBContext.newInstance(AllBooksCommand.class,
                    LogoutCommand.class, Books.class, CreateBookCommand.class);
            um = jxbc.createUnmarshaller();
            m = jxbc.createMarshaller();
            LOG.log(Level.INFO, "{0}:{1}", new Object[]{host, port});
            Socket s = new Socket(host, port);

            oos = (s.getOutputStream());
            ois = (s.getInputStream());
            isConnected = true;
        } catch (IOException ex) {
            throw new LibException(ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ConnectionServiceTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public <T> T sendCommand(AbstractLibCommand comm) throws LibException {

        if (!isConnected) {
            throw new LibException("not connected");
        }
        try {
            LOG.info(comm.toString());
            StringWriter sw = new StringWriter();
            m.marshal(comm, sw);
            LOG.info(sw.toString());
            oos.write(sw.toString().getBytes());
            oos.flush();
            Object result = um.unmarshal(ois);
            if (result instanceof LibException) {
                throw (LibException) result;
            }
            return (T) result;
        } catch (IOException | JAXBException ex) {
            throw new LibException(ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(ConnectionServiceTextImpl.class.getName());

    public void disconnect() {
        isConnected = false;
    }
}
