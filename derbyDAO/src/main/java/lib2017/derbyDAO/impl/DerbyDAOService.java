/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.derbyDAO.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib2017.integration.DAOService;
import lib2017.integration.MyBookDAO;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author danecek
 */
public class DerbyDAOService extends DAOService {

    MyBookDAO derbyBookDAO;

    @Override
    public MyBookDAO getMyBookDAO() {
        Connection conn = null;
        if (derbyBookDAO == null) {
            try {
                new EmbeddedDriver();
                String url = "jdbc:derby:" + System.getProperty("user.home") + "/libraryDB; create=true";
                conn = DriverManager.getConnection(url);
                DatabaseMetaData dbmd = conn.getMetaData();
                ResultSet rs = dbmd.getTables(null, null, "BOOKS", null);
                if (!rs.next()) {
                    LOG.info("CREATE TABLE BOOKS");
                    Statement stm = conn.createStatement();
                    stm.executeUpdate("CREATE TABLE BOOKS"
                            + "(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                            + "AUTHOR   VARCHAR(50),"
                            + "TITLE   VARCHAR(50),"
                            + "PRIMARY KEY (ID))");
                    LOG.info("TABLE BOOKS generated");

                }
                derbyBookDAO = new DerbyMyBookDAO(conn);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
        return derbyBookDAO;
    }
    private static final Logger LOG = Logger.getLogger(DerbyDAOService.class.getName());
}
