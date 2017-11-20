/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.richclient.controller.ExitAction;
import lib2017.richclient.view.BookPane;
import lib2017.richclient.view.LibMenuBar;
import lib2017.richclient.view.LibToolBar;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    public static MainWindow instance;

    public static void error(LibException ex) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(ex.toString());
    }
    BookPane bookPane;

    public MainWindow() {
        instance = this;
        setTitle(Messages.Library.getMessage());
        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                ExitAction.instance.execute();
            }
        });
        bookPane = new BookPane();
        Parent root = new VBox(new LibMenuBar(), new LibToolBar(), bookPane);
        Scene s = new Scene(root, 800, 400);
        setScene(s);
        show();
    }

    public BookPane getBookPane() {
        return bookPane;
    }
}
