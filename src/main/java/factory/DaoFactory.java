package factory;

import daoImpl.CommentDaoImpl;
import daoImpl.SearchDaoImpl;
import daoImpl.UserDaoImpl;

public class DaoFactory {
    public static UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }

    public static SearchDaoImpl getSearchDaoImpl(){return new SearchDaoImpl();}

    public static CommentDaoImpl getCommentDaoImpl(){return new CommentDaoImpl();}

}
