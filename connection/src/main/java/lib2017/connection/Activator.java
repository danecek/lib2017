package lib2017.connection;

import lib2017.richclient.MainWindow;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        MainWindow.instance.addMenu(new ConnectMenu());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
