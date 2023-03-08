package ratings;

public class Song {
    private String title;
    private String artist;
    private String songID;

    public Song(String title, String artist, String songID){
        this.title = title;
        this.artist = artist;
        this.songID = songID;

    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public String getSongID(){
        return songID;
    }
    public void setSongID(String songID){
        this.songID=songID;
    }
}
