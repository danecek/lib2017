/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.utils;

import java.sql.SQLException;

/**
 *
 * @author danecek
 */
public class LibException extends Exception {

    /**
     * Creates a new instance of <code>LibException</code> without detail
     * message.
     */
    public LibException() {
    }

    /**
     * Constructs an instance of <code>LibException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LibException(String msg) {
        super(msg);
    }
    
    public LibException(Exception ex) {
        super(ex);
    }
}
