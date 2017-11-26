/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.h2DAO.impl;

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

public class h2DAOService extends DAOService {

    MyBookDAO h2BookDAO;

    @Override
    public MyBookDAO getMyBookDAO() {
      //  Connection conn = null;
        if (h2BookDAO == null) {
            try {
                new org.h2.Driver();
                String url = "jdbc:h2:" + System.getProperty("user.home") + 
                        "/Vyuka/b-apj/2017/libH2DB";
                Connection conn = DriverManager.getConnection(url ,"sa", "");
//                DatabaseMetaData dbmd = conn.getMetaData();
//                ResultSet rs = dbmd.getTables(null, null, "BOOKS", null);
//                if (!rs.next()) {
//                    LOG.info("CREATE TABLE BOOKS");
//                    Statement stm = conn.createStatement();
//                    stm.executeUpdate("CREATE TABLE BOOKS"
//                            + "(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
//                            + "AUTHOR   VARCHAR(50),"
//                            + "TITLE   VARCHAR(50),"
//                            + "PRIMARY KEY (ID))");
//                    LOG.info("TABLE BOOKS generated");
//
//                }
                h2BookDAO = new H2MyBookDAO(conn);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
        return h2BookDAO;
    }
    private static final Logger LOG = Logger.getLogger(h2DAOService.class.getName());
}
