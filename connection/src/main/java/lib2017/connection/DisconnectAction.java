/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.connection;

import lib2017.richclient.controller.LibAbstractAction;
import lib2017.utils.Messages;

public class DisconnectAction extends LibAbstractAction {

    public static DisconnectAction instance = new DisconnectAction();

    public DisconnectAction() {
        super(Messages.CREATE_BOOK.getMessage());
    }

    @Override
    public void execute() {
        Connection.instance.disconnect();
    }

}
