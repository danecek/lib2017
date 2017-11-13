/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient;

import java.util.Observable;

/**
 *
 * @author danecek
 */
public class LibStateObservable extends Observable {
    
   public static LibStateObservable instance = new LibStateObservable();
   
   public void notif() {
       setChanged();
       notifyObservers();
   }
   
    
}
