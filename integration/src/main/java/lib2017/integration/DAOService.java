/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.integration;

import lib2017.integration.impl.DAOServiceDefaultImpl;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public abstract class DAOService {

    static private BundleContext bc;

    public static void setSt(BundleContext bc) {
        DAOService.bc = bc;
    }

    static private DAOService instance;

    public static DAOService service() {
        if (instance == null) {
            ServiceTracker st = new ServiceTracker(bc, DAOService.class.getName(), null);
            st.open();
            instance = (DAOService) st.getService();
            if (instance == null) {
                instance = new DAOServiceDefaultImpl();
            }
        }
        return instance;
    }

    public abstract MyBookDAO getMyBookDAO();

    //   public abstract MyReaderDAO getMyReaderDAO();
}
