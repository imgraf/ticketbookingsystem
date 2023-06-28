import java.time.LocalDateTime;

public class Ticket {
    private String name;
    private int amount;
    private String movie;
    private LocalDateTime time;
    private String seatArea;  // 'front', 'middle', 'back'
    private double price;


    public Ticket(String name, int amount, String movie, LocalDateTime time, String seatArea, double price) {
        this.name = name;
        this.amount = amount;
        this.movie = movie;
        this.time = time;
        this.seatArea = seatArea;
        this.price = price;
    }

    public Ticket(String name, int amount, String movie, LocalDateTime time) {
        this.name = name;
        this.amount = amount;
        this.movie = movie;
        this.time = time;
    }


    public int getAmount() {
        return amount;
    }

    public String getMovie() {
        return movie;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setSeatArea(String seatArea) {
        this.seatArea = seatArea;
    }
    public String getSeatArea() {
        return seatArea;
    }


    public double calculatePrice() {
        double basePrice = 10.0;
        if (seatArea.equals("middle")) {
            return basePrice * 2;
        } else if (seatArea.equals("back")) {
            return basePrice * 1.5;
        } else {
            return basePrice;
        }
    }

    public double getPrice() {
        switch (seatArea) {
            case "front":
                return 10.0;
            case "middle":
                return 20.0;
            case "back":
                return 15.0;
            default:
                return 0.0;
        }
    }

    public void setPrice(double price) {
    }

    public String getName() {
        return name;
    }
}
