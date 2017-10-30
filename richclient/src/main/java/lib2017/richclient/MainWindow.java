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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lib2017.business.FacadeService;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    public MainWindow() {
        setTitle(Messages.Library.getMessage());
        Button b = new Button("Create");
        TextField tf = new TextField();
        TextArea ta = new TextArea();
        Parent root = new VBox(ta, tf, b);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String tit = tf.getText();
                    FacadeService.service().createBook(tit);                
                    ta.setText(FacadeService.service().allBooks().toString());
                } catch (LibException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Scene s = new Scene(root, 800, 400);
        setScene(s);
        show();
    }

}
