package factory;

import dao.SearchDao;
import daoImpl.*;

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

}
