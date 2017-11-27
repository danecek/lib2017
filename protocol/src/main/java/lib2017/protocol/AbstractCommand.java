/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import lib2017.utils.LibException;

public abstract class AbstractCommand {

    public static final String OK = "ok";

    public abstract <T> T execute() throws LibException;
}
