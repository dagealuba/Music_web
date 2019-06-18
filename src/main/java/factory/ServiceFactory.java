package factory;

import service.HistoryService;
import service.SearchService;
import serviceImpl.*;

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

    public static HistoryServiceImpl getHistoryServiceImpl(){
        return new HistoryServiceImpl();
    }

    public static LoveServiceImpl getLoveServiceImpl(){
        return new LoveServiceImpl();
    }

    public static PlayListServiceImpl getPlayListServiceImpl() {
        return new PlayListServiceImpl();
    }

    public static FriendServiceImpl getFriendServiceImpl() {
        return new FriendServiceImpl();
    }
}
