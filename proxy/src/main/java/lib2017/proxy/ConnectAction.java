/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.proxy;

import lib2017.richclient.LibAbstractAction;
import lib2017.utils.Messages;

/**
 *
 * @author danecek
 */
public class ConnectAction extends LibAbstractAction {

    public static final ConnectAction instance = new ConnectAction();

    public ConnectAction() {
        super(Messages.CONNECT.getMessage());
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
