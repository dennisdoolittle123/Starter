package ratings;
import ratings.datastructures.LinkedListNode;
import java.util.LinkedList;

public class Song {
    private String title;
    private String artist;
    private String songID;
    private LinkedList<Rating> ratings;



    public Song(String title, String artist, String songID){
        this.title = title;
        this.ratings = new LinkedList<>();
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
    public void addRating(Rating rating){
        if (didReviewerRateSong(rating.getReviewerID())){
            System.out.println("Error reviewer already rated this song");


        }else{
            this.ratings.add(rating);
        }
    }
    public LinkedListNode<Rating> getRatings(){
        LinkedListNode<Rating> head = null;
        LinkedListNode<Rating> tail = null;
        for (Rating rating : ratings){
            LinkedListNode<Rating> newNode = new LinkedListNode<Rating>(rating,null);
            if (head == null){
                head = newNode;
                tail = head;
            }else{
                tail.setNext(newNode);
                tail = newNode;
            }
        }
        return head;
    }
    public double averageRating(){
        double sum = 0;
        int count = 0;
        for (Rating rating : this.ratings){
            if (rating.getRating() != -1){
                sum += rating.getRating();
                count++;
            }
        }
        if (count == 0){
            return 0;
        }
        return sum / count;
    }
    public boolean didReviewerRateSong(String reviewerID){
        for (Rating rating : this.ratings){
            if (rating.getReviewerID().equals(reviewerID)){
                return true;
            }
        }
        return false;
    }
    public void removeRatingByReviewer(Reviewer reviewer){
        this.ratings.removeIf(rating -> rating.getReviewerID().equals(reviewer));
    }




}
