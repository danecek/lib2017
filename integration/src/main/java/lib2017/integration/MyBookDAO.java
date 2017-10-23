/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import java.util.List;
import lib2017.model.MyBook;

/**
 *
 * @author danecek
 */
public interface MyBookDAO {
    void create(String title);
    List<MyBook>all();
}
