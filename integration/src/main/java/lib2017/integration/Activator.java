package lib2017.integration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
//        ServiceTracker st = new ServiceTracker(bundleContext, DAOService.class.getName(), null);
//        st.open();
        DAOService.setSt(bundleContext);//setSt(st);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
