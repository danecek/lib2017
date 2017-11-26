package lib2017.derbyDAO;

import lib2017.derbyDAO.impl.DerbyDAOService;
import lib2017.integration.DAOService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.registerService(DAOService.class.getName(), new DerbyDAOService(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        
    }
}
