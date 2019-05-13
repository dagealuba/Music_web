package factory;

import service.SearchService;
import serviceImpl.AlbumServiceImpl;
import serviceImpl.MusicServiceImpl;
import serviceImpl.CommentServiceImpl;
import serviceImpl.SearchServiceImpl;
import serviceImpl.UserServiceImpl;

public class ServiceFactory {
    public static UserServiceImpl getUserService(){
        return new UserServiceImpl();
    }

    public static MusicServiceImpl getMusicService(){
        return new MusicServiceImpl();
    }

    public static AlbumServiceImpl getAlbumService() {
        return new AlbumServiceImpl();
    }

    public static SearchService getSearchServiceImpl() {
        return new SearchServiceImpl();
    }
    public static CommentServiceImpl getCommentServiceImpl(){return new CommentServiceImpl();}

}
