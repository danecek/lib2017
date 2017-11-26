/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.utils;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Start;

@Component
public class HelloServiceImpl implements HelloService {

    @Start
    public void activate() {
        System.out.println("Hello world !");
    }

    @Override
    public String hello(String key) {
        return "Hello " + key;
    }

}
