package factory;

import serviceImpl.CommentServiceImpl;
import serviceImpl.SearchServiceImpl;
import serviceImpl.UserServiceImpl;

public class ServiceFactory {
    public static UserServiceImpl getUserService(){
        return new UserServiceImpl();
    }

    public static SearchServiceImpl getSearchServiceImpl(){return new SearchServiceImpl();}

    public static CommentServiceImpl getCommentServiceImpl(){return new CommentServiceImpl();}

}
