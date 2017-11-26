package lib2017.h2DAO;

import lib2017.h2DAO.impl.h2DAOService;
import lib2017.integration.DAOService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.registerService(DAOService.class.getName(), new h2DAOService(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        
    }
}
