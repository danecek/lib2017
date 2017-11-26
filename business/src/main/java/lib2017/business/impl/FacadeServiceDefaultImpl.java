
package lib2017.business.impl;

import java.util.List;
import lib2017.business.FacadeService;
import lib2017.integration.DAOService;
import lib2017.model.MyBook;
import lib2017.utils.LibException;


public class FacadeServiceDefaultImpl extends FacadeService {

    public FacadeServiceDefaultImpl() {
    }

    @Override
    public void createBook(String author, String title) throws LibException {
        DAOService.service().getMyBookDAO().create(author, title);
    }

    @Override
    public List<MyBook> allBooks() throws LibException {
        return DAOService.service().getMyBookDAO().all();
    }

    @Override
    public void deleteBook(MyBook book) throws LibException {
        DAOService.service().getMyBookDAO().delete(book);
    }
    
    
    
}
