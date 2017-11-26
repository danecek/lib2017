/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public final class BookPane extends TitledPane implements Observer {

    private ObservableList<MyBook> books = FXCollections.observableArrayList();
    private TableView<MyBook> bookTable;

    public BookPane() {
        super(Messages.BOOKS.getMessage(), null);
        setContent(bookTable = createContent());
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getSelectedBooks().addListener(DeleteBookAction.instance);
        LibStateObservable.instance.addObserver(this);
    }

    private TableView createContent() {
        TableView<MyBook> tv = new TableView<>();
        TableColumn<MyBook, Object> idCol = new TableColumn<>(Messages.ID.getMessage());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<MyBook, Object> authorCol = new TableColumn<>(Messages.AUTHOR.getMessage());
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<MyBook, Object> titleCol = new TableColumn<>(Messages.TITLE.getMessage());
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        tv.getColumns().addAll(idCol, authorCol, titleCol);
        tv.setItems(books);
        return tv;
    }

    public void refresh() throws LibException {
        books.setAll(FacadeService.service().allBooks());
    }

    public ObservableList<MyBook> getSelectedBooks() {
        return bookTable.getSelectionModel().getSelectedItems();
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
