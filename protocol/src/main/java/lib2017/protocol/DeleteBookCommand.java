/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class DeleteBookCommand extends AbstractCommand {

    private MyBook book;

    public DeleteBookCommand(MyBook book) {
        this.book = book;
    }

    @Override
    public <T> T execute() throws LibException {
        FacadeService.service().deleteBook(book);
        return (T) OK;
    }

    @Override
    public String toString() {
        return "DeleteBookCommand{" + "book=" + book + '}';
    }

}
