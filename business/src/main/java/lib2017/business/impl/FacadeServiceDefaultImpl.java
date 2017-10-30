
package lib2017.business.impl;

import java.util.List;
import lib2017.business.FacadeService;
import lib2017.integration.DAOService;
import lib2017.model.MyBook;


public class FacadeServiceDefaultImpl extends FacadeService {

    public FacadeServiceDefaultImpl() {
    }

    @Override
    public void createBook(String title) {
        DAOService.service().getMyBookDAO().create(title);
    }

    @Override
    public List<MyBook> allBooks() {
        return DAOService.service().getMyBookDAO().all();
    }
    
}
