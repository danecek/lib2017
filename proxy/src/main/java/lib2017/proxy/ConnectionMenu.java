/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.proxy;

import javafx.scene.control.Menu;
import lib2017.utils.Messages;

public class ConnectionMenu extends Menu {

    public ConnectionMenu() {
        super(Messages.CONNECTION.getMessage());
        getItems().addAll(ConnectAction.instance.createMenuItem());
    }
    
}
