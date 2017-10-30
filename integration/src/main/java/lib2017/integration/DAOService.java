/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import lib2017.integration.impl.DAOServiceDefaultImpl;

public abstract class DAOService {

    static private DAOService instance;

    public static DAOService service() {
        if (instance == null) {
            instance = new DAOServiceDefaultImpl();
        }
        return instance;

    }

    public abstract MyBookDAO getMyBookDAO();

    //   public abstract MyReaderDAO getMyReaderDAO();
}
