/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.model;

import lib2017.utils.HelloService;


/**
 *
 * @author danecek
 */
public class ModelHSImpl implements HelloService {

    @Override
    public String hello(String key) {
        return "model " + key;
    }

}
