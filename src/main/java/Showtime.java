import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class Showtime {
    private Movie movie;
    private LocalDateTime time;
    private int availableTickets;

    public Showtime(Movie movie, LocalDateTime time, int availableTickets) {
        this.movie = movie;
        this.time = time;
        this.availableTickets = availableTickets;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void decreaseAvailableTickets(int amount) {
        this.availableTickets -= amount;
    }
}
