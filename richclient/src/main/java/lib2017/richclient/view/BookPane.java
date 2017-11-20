/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.richclient.LibStateObservable;
import lib2017.richclient.MainWindow;
import lib2017.richclient.controller.DeleteBookAction;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

public class BookPane extends TitledPane implements Observer {

    ObservableList<MyBook> books = FXCollections.observableArrayList();

    public BookPane() {
        super(Messages.BOOKS.getMessage(), null);
        LibStateObservable.instance.addObserver(this);
        setContent(createContent());
    }
    TableView<MyBook> tv;

    private TableView createContent() {
        tv = new TableView<MyBook>();
        TableColumn<MyBook, Object> titleCol = new TableColumn<MyBook, Object>(Messages.TITLE.getMessage());
        titleCol.setCellValueFactory(new PropertyValueFactory<MyBook, Object>("title"));
        tv.getColumns().add(titleCol);
        tv.setItems(books);
        tv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getSelectedBooks().addListener(DeleteBookAction.instance);
        return tv;
    }

    public void refresh() throws LibException {
        books.setAll(FacadeService.service().allBooks());
    }

    public ObservableList<MyBook> getSelectedBooks() {
        return tv.getSelectionModel().getSelectedItems();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            refresh();
        } catch (LibException ex) {
            MainWindow.error(ex);
        }
    }

}
