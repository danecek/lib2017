package lib2017.connection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ConnectionService.setBc(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
