/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.connection;

import javafx.scene.control.Menu;
import lib2017.utils.Messages;

/**
 *
 * @author danecek
 */
public class ConnectMenu extends Menu {

    public ConnectMenu() {
        super(Messages.CONNECTION.getMessage());
        getItems().addAll(ConnectAction.instance.createMenuItem(),
                DisconnectAction.instance.createMenuItem());
    }

}
