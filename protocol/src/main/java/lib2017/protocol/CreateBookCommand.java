/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import lib2017.business.FacadeService;
import lib2017.utils.LibException;

/**
 *
 * @author danecek
 */
public class CreateBookCommand extends AbstractLibCommand {

    private String author;
    private String title;

    public CreateBookCommand(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    <T> T execute() throws LibException {
        FacadeService.service().createBook(author, title);
        return (T) OK;
    }

}
