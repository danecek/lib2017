/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.model;


public class MyBook {

    public MyBook(BookId id, String title) {
        this.id = id;
        this.title = title;
    }   
    

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    BookId id;
    String title;
    
}
