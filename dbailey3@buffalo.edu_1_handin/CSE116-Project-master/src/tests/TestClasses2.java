package tests;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.Movie;
import java.util.ArrayList;
import ratings.datastructures.Comparator;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses2 {

    @Test
    public void testBayesianAverageRatingWithnoExtraRatings(){
        Song song = new Song("Sabor A Mi","Luis Miguel","ID");
        double bayesianAvg = song.bayesianAverageRating(0,0);
        assertEquals(0.0, bayesianAvg, 0.01);

    }
    @Test
    public void testBayesianAverageRatingWithRatings() {
        Song song = new Song("Life We Live", "Project Pat", "ID");
        double bayesianAvg = song.bayesianAverageRating(0, 0);
        assertEquals(0.0, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithExtraRatings() {
        Song song = new Song("Solid", "Drake", "ID");
        song.addRating(new Rating("Reviewer1", 4));
        song.addRating(new Rating("Reviewer2", 5));
        double bayesianAvg = song.bayesianAverageRating(2, 3);
        assertEquals(3.75, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithOnlyExtraRatings() {
        Song song = new Song("New Patek", "Uzi", "ID");
        double bayesianAvg = song.bayesianAverageRating(3, 5);
        assertEquals(5.0, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithOneExtraRating() {
        Song song = new Song("20 min", "Uzi", "ID");
        song.addRating(new Rating("Reviewer1", 4));
        double bayesianAvg = song.bayesianAverageRating(1, 2);
        assertEquals(3.33, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithMultipleExtraRatings() {
        Song song = new Song("Title", "Artist", "ID");
        song.addRating(new Rating("Reviewer1", 5));
        song.addRating(new Rating("Reviewer2", 3));
        double bayesianAvg = song.bayesianAverageRating(5, 1);
        assertEquals(3.5, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithNegativeExtraRatings() {
        Song song = new Song("Title", "Artist", "ID");
        song.addRating(new Rating("Reviewer1", 4));
        double bayesianAvg = song.bayesianAverageRating(-2, 3);
        assertEquals(4.0, bayesianAvg, 0.01);
    }
    @Test
    public void testBayesianAverageRatingWithZeroExtraRatings() {
        Song song = new Song("Title", "Artist", "ID");

        song.addRating(new Rating("Reviewer1", 4));
        song.addRating(new Rating("Reviewer2", 5));
        double bayesianAvg = song.bayesianAverageRating(0, 0);
        assertEquals(4.5, bayesianAvg, 0.01);
    }
    //Movie tests
    @Test
    public void testGetTitle(){
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("John Favreau");
        cast.add("Chris Pratt Mario");
        cast.add("Steve");


        Movie movie = new Movie ("Mario", cast);
        assertEquals("Mario", movie.getTitle());
    }
    @Test
    public void testGetCast(){
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Chef");
        cast.add("My name");
        cast.add("Minecraft");
        Movie movie = new Movie("Minecraft movie", cast);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("chef");
        expected.add("my name");
        expected.add("minecraft");
        assertEquals(expected, movie.getCast());
    }
        @Test
        public void testComparatorCompare() {
            Comparator<String> stringComparator = new Comparator<String>();
            assertTrue(!stringComparator.compare("apple", "banana"));
            assertTrue(!stringComparator.compare("banana", "apple"));
            assertTrue(!stringComparator.compare("apple", "apple"));

            Comparator<Integer> integerComparator = new Comparator<Integer>();
            assertTrue(!integerComparator.compare(1, 2));
            assertTrue(!integerComparator.compare(2, 1));
            assertTrue(!integerComparator.compare(1, 1));

            Song song1 = new Song("Title A", "Artist A", "ID A");
            Song song2 = new Song("Title B", "Artist B", "ID B");
            Song song3 = new Song("Title C", "Artist C", "ID C");

            Comparator<Song> titleComparator = new SongTitleComparator();
            assertTrue(titleComparator.compare(song1, song2));
            assertTrue(!titleComparator.compare(song2, song1));
            assertTrue(!titleComparator.compare(song1, song1));


        }

    }

