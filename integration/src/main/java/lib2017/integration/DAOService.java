/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import lib2017.integration.impl.DAOServiceDefaultImpl;
import org.osgi.util.tracker.ServiceTracker;

public abstract class DAOService {

    public static void setSt(ServiceTracker<DAOService, DAOService> aSt) {
        st = aSt;
    }

    private static ServiceTracker<DAOService, DAOService> st;

    static private DAOService instance;

    public static DAOService service() {
        if (instance == null) {
            if (st != null)
               instance = st.getService();
            if (instance == null) {
                instance = new DAOServiceDefaultImpl();
            }
        }
        return instance;
    }

    public abstract MyBookDAO getMyBookDAO();

    //   public abstract MyReaderDAO getMyReaderDAO();
}
