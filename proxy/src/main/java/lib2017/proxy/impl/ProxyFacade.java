/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.proxy.impl;

import lib2017.connection.Connection;
import java.util.List;
import lib2017.business.FacadeService;
import lib2017.model.MyBook;
import lib2017.protocol.AllBooksCommand;
import lib2017.protocol.CreateBookCommand;
import lib2017.protocol.DeleteBookCommand;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class ProxyFacade extends FacadeService {

    @Override
    public void createBook(String author, String title) throws LibException {
        Connection.instance.send(new CreateBookCommand(author, title));
    }

    @Override
    public List<MyBook> allBooks() throws LibException {
        return Connection.instance.send(new AllBooksCommand());
    }

    @Override
    public void deleteBook(MyBook book) throws LibException {
        Connection.instance.send(new DeleteBookCommand(book));
    }

}
