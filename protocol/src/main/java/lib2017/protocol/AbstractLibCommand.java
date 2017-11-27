/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import java.io.Serializable;
import lib2017.utils.LibException;


public abstract class AbstractLibCommand implements Serializable{
    
    abstract <T> T execute() throws LibException;
    public static final String OK ="ok";
    
}
