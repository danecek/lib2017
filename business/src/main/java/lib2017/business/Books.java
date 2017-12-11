/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.business;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lib2017.model.MyBook;

@XmlRootElement
public class Books {

    private List<MyBook> books;

    public Books() {
    }

    public Books(List<MyBook> books) {
        this.books = books;
    }

    /**
     * @return the books
     */
    public List<MyBook> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<MyBook> books) {
        this.books = books;
    }

}
