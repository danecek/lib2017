/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.derbyDAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib2017.integration.MyBookDAO;
import lib2017.model.MyBook;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class DerbyMyBookDAO implements MyBookDAO {

    private PreparedStatement createPs;
    private PreparedStatement allPs;
    private PreparedStatement deletePs;

    public DerbyMyBookDAO(Connection conn) {
        try {
            allPs = conn.prepareStatement("select * from BOOKS");
            createPs = conn.prepareStatement("insert into BOOKS values(default, ?, ?)");
            deletePs = conn.prepareStatement("delete from BOOKS where id =?");
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(String author, String title) throws LibException {
        try {
            createPs.setString(1, author);
            createPs.setString(2, title);
            createPs.executeUpdate();
        } catch (SQLException ex) {
            throw new LibException(ex);
        }
    }

    @Override
    public void delete(MyBook book) throws LibException {
        try {
            deletePs.setInt(1, book.getId().getId());
            deletePs.executeUpdate();
        } catch (SQLException ex) {
            throw new LibException(ex);
            //      Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<MyBook> all() throws LibException {

        try {
            List<MyBook> books = new ArrayList<>();
            ResultSet rs = allPs.executeQuery();
            while (rs.next()) {
                books.add(new MyBook(rs.getInt(1),
                        rs.getString(2), rs.getString(3)));
            }
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibException(ex); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
