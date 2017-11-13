/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import javafx.scene.control.Menu;
import lib2017.richclient.controller.CreateBookAction;
import lib2017.utils.Messages;


public class BookMenu extends Menu {

    public BookMenu() {
        super(Messages.BOOKS.getMessage());
        getItems().addAll(CreateBookAction.instance.createMenuItem());
    }
    
}
