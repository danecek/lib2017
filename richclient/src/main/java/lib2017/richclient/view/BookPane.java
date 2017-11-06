/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

public class BookPane extends TitledPane {

    ObservableList<MyBook> books = FXCollections.observableArrayList();

    public BookPane() {
        super(Messages.BOOKS.getMessage(), null);
        setContent(createContent());
    }

    private Node createContent() {
        TableView<MyBook> tv = new TableView<MyBook>();
        TableColumn<MyBook, Object> titleCol = new TableColumn<MyBook, Object>(Messages.TITLE.getMessage());
        titleCol.setCellValueFactory(new PropertyValueFactory<MyBook, Object>("title"));
        tv.getColumns().add(titleCol);
        tv.setItems(books);
        return tv;
    }

    public void refresh() throws LibException {
        books.setAll(FacadeService.service().allBooks());
    }

}
