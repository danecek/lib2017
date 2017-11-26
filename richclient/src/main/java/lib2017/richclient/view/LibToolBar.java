/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import lib2017.richclient.controller.CreateBookAction;
import lib2017.richclient.controller.DeleteBookAction;
import lib2017.richclient.controller.ExitAction;

/**
 *
 * @author danecek
 */
public class LibToolBar extends HBox {

    public LibToolBar() {
        super(ExitAction.instance.createButton(),
                CreateBookAction.instance.createButton(),
                DeleteBookAction.instance.createButton());
        setPadding(new Insets(5));
        setSpacing(5);
    }

}
