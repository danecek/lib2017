/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public abstract class LibAbstractAction {

    private String name;
    protected SimpleBooleanProperty disable = new SimpleBooleanProperty(false);

    public LibAbstractAction(String name) {
        this.name = name;
    }

    public abstract void execute();

    public Button createButton() {
        Button bt = new Button(name);
        bt.disableProperty().bind(disable);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return bt;
    }

    public MenuItem createMenuItem() {
        MenuItem bt = new MenuItem(name);
        bt.disableProperty().bind(disable);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return bt;
    }

}
