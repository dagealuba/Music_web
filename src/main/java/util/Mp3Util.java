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
import java.io.FileInputStream;
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

    public static String uploadPic( File mp3, String path, boolean cover ) {
        byte[] pic = null;
        try {
            if ( !cover ){
                File tempFile = new File(path);

                if (tempFile.exists()){
                    return null;
                }
            }

            MP3File mp3File = new MP3File(mp3);
            AbstractID3v2Tag abstractID3v2Tag = mp3File.getID3v2Tag();
            AbstractID3v2Frame frame = (AbstractID3v2Frame) abstractID3v2Tag.getFrame("APIC");
            FrameBodyAPIC bodyAPIC = (FrameBodyAPIC) frame.getBody();

            pic = bodyAPIC.getImageData();


            if ( pic == null || pic.length == 0){
                return null;
            }

            FileOutputStream out = new FileOutputStream(path);
            out.write(pic);
            out.close();

            FileInputStream fileInputStream = new FileInputStream(path);
            byte[] bytes = new byte[3];
            fileInputStream.read(bytes,0,bytes.length);
            fileInputStream.close();
            String type = bytesToHexString(bytes);
            type = checkType(type.toUpperCase());
            if (type.equals("png")){
                File file = new File(path);
                String name = file.getAbsolutePath();
//                System.out.println(name);
                name = name.substring(0,name.lastIndexOf("."))+".png";
//                System.out.println(name);
                file.renameTo(new File(name));
            }

            return type;


        } catch (Exception e){
            return null;
        }

    }

    public static String bytesToHexString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String checkType(String src){
        switch (src){
            case "FFD8FF": return "jpg";
            case "89504E": return "png";

            default:return "other";
        }
    }
}
