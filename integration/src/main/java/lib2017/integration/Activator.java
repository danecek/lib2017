package lib2017.integration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        DAOService.setSt(new ServiceTracker<>(bundleContext, DAOService.class.getName(), null));
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
