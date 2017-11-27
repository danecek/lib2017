/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.protocol;

import lib2017.business.FacadeService;
import lib2017.utils.LibException;

public class DeleteCommand extends AbstractCommand {

    @Override
    public <T> T execute() throws LibException {
        return (T) FacadeService.service().allBooks();
    }

}
