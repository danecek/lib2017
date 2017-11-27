package lib2017.utils;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

//    @Override
//    public void init(BundleContext context, DependencyManager manager) throws Exception {
//        manager.add(createComponent()
//                .setInterface(HelloService.class.getName(), null)
//                .setImplementation(HelloServiceImpl.class)
//        );
//        LOG.info("init");
//    }
    @Override
    public void stop(BundleContext bc) throws Exception {
        //    LOG.info("");
    }

    @Override
    public void start(BundleContext bc) throws Exception {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
