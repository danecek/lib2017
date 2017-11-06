package lib2017.richclient;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import lib2017.richclient.controller.ExitAction;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ExitAction.instance.setBundleContext(bundleContext);
                new MainWindow();
            }
        });
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
    }
}
