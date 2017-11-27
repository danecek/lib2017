/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public abstract class LibAbstractDialog extends Dialog<ButtonType> implements ChangeListener<Object> {

    protected Label errorPane = new Label();

    public LibAbstractDialog() {
        errorPane.setStyle(" -fx-text-fill:red; -fx-font-weight:bold");
    }

    protected TextField createTF() {
        TextField tf = new TextField();
        tf.textProperty().addListener(this);
        return tf;
    }

    protected abstract Node createContent();

    public abstract void execute();

    protected  abstract void validate();

    @Override
    public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
        validate();
    }

}
