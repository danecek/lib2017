/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.richclient.LibStateObservable;
import lib2017.richclient.MainWindow;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

public class DeleteBookAction extends LibAbstractAction implements ListChangeListener<MyBook> {

    private static final Logger LOG = Logger.getLogger(DeleteBookAction.class.getName());

    public static DeleteBookAction instance = new DeleteBookAction();

    public DeleteBookAction() {
        super(Messages.DELETE_BOOK.getMessage());
        disable.set(true);
    }

    @Override
    public void execute() {
        try {
            for (MyBook book : MainWindow.instance.getBookPane().getSelectedBooks()) {
                FacadeService.service().deleteBook(book);
            }
            LibStateObservable.instance.notif();
        } catch (LibException ex) {
            MainWindow.error(ex);
        }
    }

    @Override
    public void onChanged(Change<? extends MyBook> c) {
        disable.set(MainWindow.instance.getBookPane().getSelectedBooks().isEmpty());
    }

}
