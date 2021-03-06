package factory;

import dao.HistoryDao;
import daoImpl.*;
import entity.PlayList;

public class DaoFactory {
    public static UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }

    public static MusicDaoImpl getMusicDaoImpl() {
        return new MusicDaoImpl();
    }

    public static AlbumDaoImpl getAlbumDaoImpl() {
        return new AlbumDaoImpl();
    }

    public static SearchDaoImpl getSearchDaoImpl(){return new SearchDaoImpl();}

    public static CommentDaoImpl getCommentDaoImpl(){return new CommentDaoImpl();}

    public static LikeCommentDaoImpl getLikeCommentDaoImpl(){
        return new LikeCommentDaoImpl();
    }

    public static HistoryDaoImpl getHistoryDaoImpl(){
        return new HistoryDaoImpl();
    }

    public static LoveDaoImpl getLoveDaoImpl(){
        return new LoveDaoImpl();
    }

    public static PlayListDaoImpl getPlayListDaoImpl(){
        return new PlayListDaoImpl();
    }

    public static FriendDaoImpl getFriendDaoImpl(){
        return new FriendDaoImpl();
    }
}
