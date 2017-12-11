package lib2017.connectionText;

import lib2017.connection.ConnectionService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.registerService(ConnectionService.class,
                new ConnectionServiceTextImpl(), null);

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
