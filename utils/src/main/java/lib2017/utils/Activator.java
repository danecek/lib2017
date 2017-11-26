package lib2017.utils;

import java.util.logging.Logger;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent()
                .setInterface(HelloService.class.getName(), null)
                .setImplementation(HelloServiceImpl.class)
        );
        LOG.info("init");
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        LOG.info("");
    }

}
