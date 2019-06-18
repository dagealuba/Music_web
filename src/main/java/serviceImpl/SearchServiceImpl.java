package serviceImpl;

import entity.Album;
import entity.Music;
import util.Album_m;
import util.Music_a;
import factory.DaoFactory;
import service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Music_a> FindSinger(String singer) {
        List<Music> musicList = DaoFactory.getSearchDaoImpl().SearchSinger(singer);
        List<Music_a> music_as = new ArrayList<Music_a>();

        for (Music music : musicList) {
            music_as.add(new Music_a(music));
        }

        return music_as;
    }

    @Override
    public List<Music_a> FindMusicName(String musicName) {
        List<Music> musicList = DaoFactory.getSearchDaoImpl().SearchMusicName(musicName);
        List<Music_a> music_as = new ArrayList<Music_a>();

        for (Music music: musicList){
//            System.out.println(music.getMusicName());
            music_as.add(new Music_a(music));
        }

        return music_as;
    }

    @Override
    public List<Album> FindAlbumName(String albumName) {
        return DaoFactory.getSearchDaoImpl().SearchAlbum(albumName);
    }

    @Override
    public Music_a FindMusicById(String musicId) {
        Music music = DaoFactory.getSearchDaoImpl().SearchMusicId(musicId);
        if (music != null){
            return new Music_a(music);
        }
        return null;
    }

    @Override
    public List<Album_m> FindMusicByAlbum(String albumName) {
        List<Album> albums = FindAlbumName(albumName);
//        System.out.println(albums.size());

        List<Album_m> album_ms = new ArrayList<>();
        for (Album album:albums){
            List<Music> musics = DaoFactory.getMusicDaoImpl().getMusicsByAlbum(album.getAlbumId());
            System.out.println(musics.size());
            List<Music_a> music_as = new ArrayList<>();
            for (Music music:musics){
                music_as.add(new Music_a(music));
            }

            Album_m album_m = new Album_m(album.getAlbumId(), album.getAlbumName(),album.getSinger(),music_as);
            album_ms.add(album_m);
        }

        return album_ms;
    }


}
