/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.controller;

import lib2017.richclient.LibAbstractAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib2017.richclient.MainWindow;
import lib2017.utils.Messages;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 *
 * @author danecek
 */
public class ExitAction extends LibAbstractAction {

    /**
     * @param bundleContext the bundleContext to set
     */
    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public static ExitAction instance = new ExitAction();
    private BundleContext bundleContext;

    public ExitAction() {
        super(Messages.EXIT.getMessage());
    }

    @Override
    public void execute() {
        try {
            Bundle sb = bundleContext.getBundle(0);
            sb.stop(1000);
        } catch (BundleException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
