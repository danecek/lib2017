package lib2017.binserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new ServerTask(es));
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
