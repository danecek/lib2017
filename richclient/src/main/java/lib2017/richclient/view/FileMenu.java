/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import javafx.scene.control.Menu;
import lib2017.richclient.controller.ExitAction;
import lib2017.utils.Messages;

/**
 *
 * @author danecek
 */
public class FileMenu extends Menu {

    public FileMenu() {
        super(Messages.FILE.getMessage());
        getItems().addAll(ExitAction.instance.createMenuItem());
    }
    
}
