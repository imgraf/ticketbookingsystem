import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void testMovieCreation() {
        String[] actors = {"Actor1", "Actor2"};
        Movie movie = new Movie("Title", "Genre", "Director", actors);

        assertEquals("Title", movie.getTitle());
        assertEquals("Genre", movie.getGenre());
        assertEquals("Director", movie.getDirector());
        assertArrayEquals(actors, movie.getActors());
    }
}
