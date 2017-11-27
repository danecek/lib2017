package lib2017.proxy;

import javafx.application.Platform;
import lib2017.business.FacadeService;
import lib2017.richclient.MainWindow;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.instance.addMenu(new ConnectionMenu());
            }
        });
        bundleContext.registerService(FacadeService.class, new ProxyFacadeService(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
