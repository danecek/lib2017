/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.derbyDAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    //   private final PreparedStatement deletePs;

    public DerbyMyBookDAO(Connection conn) {
        try {
            allPs = conn.prepareStatement("select * from BOOKS");
            createPs = conn.prepareStatement("insert into BOOKS values(default, ?1)");
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(String title) throws LibException {
        try {
            createPs.setString(1, title);
            createPs.executeUpdate();
        } catch (SQLException ex) {
            throw new LibException(ex);
        }
    }

    @Override
    public void delete(MyBook book) throws LibException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MyBook> all() throws LibException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
