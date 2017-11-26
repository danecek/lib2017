/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import java.util.List;
import lib2017.model.MyBook;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public interface MyBookDAO {

    void create(String author, String title) throws LibException;

    void delete(MyBook book) throws LibException;

    List<MyBook> all() throws LibException;
}
