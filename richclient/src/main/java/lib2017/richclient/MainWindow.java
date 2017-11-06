/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lib2017.business.FacadeService;
import lib2017.richclient.controller.ExitAction;
import lib2017.richclient.view.BookPane;
import lib2017.utils.LibException;
import lib2017.utils.Messages;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {
    
    public static MainWindow instance;

    public MainWindow() {
        instance = this;
        setTitle(Messages.Library.getMessage());
        Button b = new Button("Create");
        TextField tf = new TextField();
        BookPane bookPane = new BookPane();
        Parent root = new VBox(bookPane, tf, b, ExitAction.instance.createButton());
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String tit = tf.getText();
                    FacadeService.service().createBook(tit);
                    bookPane.refresh();
                    // ta.setText(FacadeService.service().allBooks().toString());
                } catch (LibException ex) {

                    new Alert(Alert.AlertType.ERROR).setContentText(ex.toString());
                }
            }
        });
        Scene s = new Scene(root, 800, 400);
        setScene(s);
        show();
    }
}
