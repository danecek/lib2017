/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import lib2017.business.FacadeService;
import lib2017.utils.LibException;

@XmlRootElement
public class CreateBookCommand extends AbstractLibCommand {

    private String author;
    private String title;

    public CreateBookCommand() {
    }

    public CreateBookCommand(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public <T> T execute() throws LibException {
        FacadeService.service().createBook(author, title);
        return (T) OK;
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

}
