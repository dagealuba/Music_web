package util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mp3Util {

    private static String getString(String str) {
        Pattern p = Pattern.compile("(?<=\").*?(?=\")");
        Matcher m = p.matcher(str);

        while (m.find()){
            str = m.group();
        }

        return str;
    }

    public static String getSinger(File mp3){
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(mp3);

            String singer = mp3File.getID3v2Tag().frameMap.get("TPE1").toString();
            return getString(singer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getSongName(File mp3){
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(mp3);

            String songName = mp3File.getID3v2Tag().frameMap.get("TIT2").toString();
            return getString(songName);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getAlbum(File mp3) {
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(mp3);

            String album = mp3File.getID3v2Tag().frameMap.get("TALB").toString();

            return getString(album);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getTime(File mp3){
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(mp3);
            MP3AudioHeader mp3AudioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

            return mp3AudioHeader.getTrackLength();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean uploadPic( File mp3, String path, boolean cover ) {
        byte[] pic = null;
        try {
            if ( !cover ){
                File tempFile = new File(path);

                if (tempFile.exists()){
                    return true;
                }
            }

            MP3File mp3File = new MP3File(mp3);
            AbstractID3v2Tag abstractID3v2Tag = mp3File.getID3v2Tag();
            AbstractID3v2Frame frame = (AbstractID3v2Frame) abstractID3v2Tag.getFrame("APIC");
            FrameBodyAPIC bodyAPIC = (FrameBodyAPIC) frame.getBody();

            pic = bodyAPIC.getImageData();

            if ( pic == null || pic.length == 0){
                return false;
            }

            FileOutputStream out = new FileOutputStream(path);
            out.write(pic);
            out.close();

            return true;


        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }

        return false;
    }
}
