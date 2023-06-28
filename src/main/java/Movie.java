public class Movie {
    private String title;
    private String genre;
    private String director;
    private String[] actors;

    public Movie(String title, String genre, String director, String[] actors) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String[] getActors() {
        return actors;
    }

}
