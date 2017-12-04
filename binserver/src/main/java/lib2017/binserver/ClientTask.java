/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.binserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import lib2017.protocol.AbstractLibCommand;
import lib2017.protocol.LogoutCommand;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class ClientTask implements Runnable {

    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket s;
    private static final Logger LOG = Logger.getLogger(ClientTask.class.getName());

    public ClientTask(Socket s) throws IOException {
        this.s = s;
        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());

    }

    @Override
    public void run() {
        try (ObjectInputStream ois = this.ois;
                ObjectOutputStream oos = this.oos;
                Socket s = this.s) {
            for (;;) {
                LOG.info("waiting for comm");
                Object result;
                try {
                    AbstractLibCommand comm = (AbstractLibCommand) ois.readObject();
                    if (comm instanceof LogoutCommand) {
                        break;
                    }
                    LOG.info(comm.toString());
                    result = comm.execute();
                } catch (LibException ex) {
                    result = ex;
                }
                LOG.info(result.toString());
                oos.writeObject(result);
                oos.flush();
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

}
