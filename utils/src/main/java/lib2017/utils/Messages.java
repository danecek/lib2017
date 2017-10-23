/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public enum Messages {

    Library,
    Book;
    Locale l = new Locale("cs");//Locale.US;

    public String getMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("lib2017.utils.messages", l);
        String mess;
        try {
            mess = bundle.getString(this.name());
        } catch (MissingResourceException mre) {
            LOG.warning(mre.toString());
            mess = name();
        }
        return mess;

    }
    private static final Logger LOG = Logger.getLogger(Messages.class.getName());

}
