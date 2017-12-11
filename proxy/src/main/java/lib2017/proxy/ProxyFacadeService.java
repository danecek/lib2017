/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.proxy;

import lib2017.business.Books;
import lib2017.business.FacadeService;
import lib2017.connection.ConnectionService;
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
        ConnectionService.service().sendCommand(new CreateBookCommand(author, title));
    }

    @Override
    public Books allBooks() throws LibException {
        return ConnectionService.service().sendCommand(new AllBooksCommand());
    }

    @Override
    public void deleteBook(MyBook book) throws LibException {
     //   Connection.instance.sendCommand(new CreateBookCommand(author, title));
    }

}
