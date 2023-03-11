package ratings;
import ratings.Rating;
import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<String>cast;
    private ArrayList<Integer> ratings;

    public Movie(String title, ArrayList<String> cast){
        this.title = title;
        this.cast = cast;
    }

    public String getTitle(){
        //stubbed out (for now)
        return null;
    }
    public ArrayList<String> getCast(){
        // stubbed out
        return null;
    }
    public void addRating(int rating){
        //stubbed out
    }
    public double bayseianAverageRating(int extraRatings,double extraValue){
        //stubbed out
        return 0.0;
    }

}
