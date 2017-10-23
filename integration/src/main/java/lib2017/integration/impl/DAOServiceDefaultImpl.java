/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration.impl;

import lib2017.integration.DAOService;
import lib2017.integration.MyBookDAO;


public class DAOServiceDefaultImpl extends DAOService {

    @Override
    public MyBookDAO getMyBookDAO() {
        return MyBookDAOImpl.instance;
    }

}
