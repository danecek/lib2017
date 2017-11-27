/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.richclient.controller;

import lib2017.richclient.LibAbstractAction;
import lib2017.richclient.dialogs.CreateBookDialog;
import lib2017.utils.Messages;


public class CreateBookAction extends LibAbstractAction {

    public static CreateBookAction instance = new CreateBookAction();

    public CreateBookAction() {
        super(Messages.CREATE_BOOK.getMessage());
    }

    @Override
    public void execute() {
        new CreateBookDialog().execute();
    }

}
