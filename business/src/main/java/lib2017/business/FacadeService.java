/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.business;

import java.util.List;
import lib2017.business.impl.FacadeServiceDefaultImpl;
import lib2017.model.MyBook;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public abstract class FacadeService {

    private static FacadeService instance;

    public static FacadeService service() {
        if (instance == null) {
            instance = new FacadeServiceDefaultImpl();
        }
        return instance;

    }

    public abstract void createBook(String author, String title) throws LibException;

    public abstract List<MyBook> allBooks() throws LibException;
     
    public abstract void deleteBook(MyBook book) throws LibException;

}
