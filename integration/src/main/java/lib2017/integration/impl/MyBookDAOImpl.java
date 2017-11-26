/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import lib2017.integration.MyBookDAO;
import lib2017.model.BookId;
import lib2017.model.MyBook;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class MyBookDAOImpl implements MyBookDAO {

    public static MyBookDAOImpl instance = new MyBookDAOImpl();

    private MyBookDAOImpl() {
    }

    private NavigableMap<BookId, MyBook> books = new TreeMap<>();

    @Override
    public void create(String author, String title) {
        int lk = 0;
        if (books.isEmpty()) {
            lk = 0;
        } else {
            lk = books.lastKey().getId();
        }
        MyBook book = new MyBook(lk + 1, author, title);
        books.put(book.getId(), book);
    }

    @Override
    public List<MyBook> all() {
        return new ArrayList(books.values());
    }

    @Override
    public void delete(MyBook book) throws LibException {
        books.remove(book.getId());
    }

}
