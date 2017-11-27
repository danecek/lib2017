/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import lib2017.business.FacadeService;
import lib2017.utils.LibException;

public class CreateBookCommand extends AbstractCommand {

    private String author;
    private String title;

    public CreateBookCommand(String author, String title) {
        this.author = author;
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CreateBookCommand{" + "author=" + author + ", title=" + title + '}';
    }

    @Override
    public <T> T execute() throws LibException {
        FacadeService.service().createBook(author, title);
        return (T) OK;
    }

}
