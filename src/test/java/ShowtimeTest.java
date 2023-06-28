import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ShowtimeTest {

    @Test
    void decreaseAvailableTicketsTest() {
        String[] actors = {"Actor 1", "Actor 2"};
        Movie movie = new Movie("Test Movie", "Test Genre", "Test Director", actors);
        LocalDateTime now = LocalDateTime.now();
        Showtime showtime = new Showtime(movie, now, 10);

        showtime.decreaseAvailableTickets(5);
        assertEquals(5, showtime.getAvailableTickets());

        showtime.decreaseAvailableTickets(2);
        assertEquals(3, showtime.getAvailableTickets());
    }

    @Test
    void getMovieTest() {
        String[] actors = {"Actor 1", "Actor 2"};
        Movie movie = new Movie("Test Movie", "Test Genre", "Test Director", actors);
        LocalDateTime now = LocalDateTime.now();
        Showtime showtime = new Showtime(movie, now, 10);

        assertEquals(movie, showtime.getMovie());
    }

    @Test
    void getTimeTest() {
        String[] actors = {"Actor 1", "Actor 2"};
        Movie movie = new Movie("Test Movie", "Test Genre", "Test Director", actors);
        LocalDateTime now = LocalDateTime.now();
        Showtime showtime = new Showtime(movie, now, 10);

        assertEquals(now, showtime.getTime());
    }

    @Test
    void getAvailableTicketsTest() {
        String[] actors = {"Actor 1", "Actor 2"};
        Movie movie = new Movie("Test Movie", "Test Genre", "Test Director", actors);
        LocalDateTime now = LocalDateTime.now();
        Showtime showtime = new Showtime(movie, now, 10);

        assertEquals(10, showtime.getAvailableTickets());
    }
}
