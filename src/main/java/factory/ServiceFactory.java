package factory;

import serviceImpl.AlbumServiceImpl;
import serviceImpl.MusicServiceImpl;
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
}
