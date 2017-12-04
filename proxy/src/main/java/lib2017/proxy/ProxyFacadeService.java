/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.proxy;

import java.util.List;
import lib2017.business.FacadeService;
import lib2017.connection.Connection;
import lib2017.model.MyBook;
import lib2017.protocol.AllBooksCommand;
import lib2017.protocol.CreateBookCommand;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class ProxyFacadeService extends FacadeService {

    @Override
    public void createBook(String author, String title) throws LibException {
        Connection.instance.sendCommand(new CreateBookCommand(author, title));
    }

    @Override
    public List<MyBook> allBooks() throws LibException {
        return Connection.instance.sendCommand(new AllBooksCommand());
    }

    @Override
    public void deleteBook(MyBook book) throws LibException {
     //   Connection.instance.sendCommand(new CreateBookCommand(author, title));
    }

}
