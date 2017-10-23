/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import java.util.List;
import lib2017.integration.impl.MyBookDAOImpl;
import lib2017.model.MyBook;
import org.junit.Assert;

/**
 *
 * @author danecek
 */
public class MyBookDAOTest {
    
    public MyBookDAOTest() {
    }

    @org.junit.Test
    public void testCreate() {
        MyBookDAOImpl bdao = MyBookDAOImpl.instance;
        bdao.create("Maj");
        Assert.assertTrue(bdao.all().get(0).getTitle().equals("Maj"));    
    }

    @org.junit.Test
    public void testAll() {
    }

//    public class MyBookDAOImpl implements MyBookDAO {
//
//        public void create(String title) {
//        }
//
//        public List<MyBook> all() {
//            return null;
//        }
//    }
    
}
