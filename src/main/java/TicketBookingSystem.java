import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TicketBookingSystem {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    private Map<String, Ticket> tickets;
    private List<Showtime> showtimes;
    private Scanner sc;
    private Random rand;
    private String seatArea;


    public TicketBookingSystem() {
        this.tickets = new HashMap<>();
        this.showtimes = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.rand = new Random();

        String[] actors1 = {"Tim Robbins", "Morgan Freeman"};
        Movie movie1 = new Movie("The Shawshank Redemption", "Drama", "Frank Darabont", actors1);

        String[] actors2 = {"Marlon Brando", "Al Pacino"};
        Movie movie2 = new Movie("The Godfather", "Crime", "Francis Ford Coppola", actors2);

        String[] actors3 = {"John Travolta", "Uma Thurman"};
        Movie movie3 = new Movie("Pulp Fiction", "Crime", "Quentin Tarantino", actors3);

        String[] actors4 = {"Brad Pitt", "Edward Norton"};
        Movie movie4 = new Movie("Fight Club", "Drama", "David Fincher", actors4);

        String[] actors5 = {"Tom Hanks", "Robin Wright"};
        Movie movie5 = new Movie("Forrest Gump", "Drama", "Robert Zemeckis", actors5);

        String[] actors6 = {"Leonardo DiCaprio", "Elliot Page"};
        Movie movie6 = new Movie("Inception", "Sci-Fi", "Christopher Nolan", actors6);

        String[] actors7 = {"Christian Bale", "Heath Ledger"};
        Movie movie7 = new Movie("The Dark Knight", "Action", "Christopher Nolan", actors7);

        String[] actors8 = {"Keanu Reeves", "Laurence Fishburne"};
        Movie movie8 = new Movie("Matrix", "Sci-Fi", "Lana Wachowski, Lilly Wachowski", actors8);

        String[] actors9 = {"Robert Downey Jr.", "Chris Evans"};
        Movie movie9 = new Movie("Avengers: Endgame", "Action", "Anthony Russo, Joe Russo", actors9);

        String[] actors10 = {"Matthew McConaughey", "Anne Hathaway"};
        Movie movie10 = new Movie("Interstellar", "Sci-Fi", "Christopher Nolan", actors10);



        Showtime showtime1 = new Showtime(movie1, LocalDateTime.of(2023, 7, 1, 17, 0), 100);
        Showtime showtime2 = new Showtime(movie1, LocalDateTime.of(2023, 7, 1, 20, 0), 100);
        Showtime showtime3 = new Showtime(movie2, LocalDateTime.of(2023, 7, 1, 17, 0), 100);
        Showtime showtime4 = new Showtime(movie4, LocalDateTime.of(2023, 7, 1, 18, 0), 100);
        Showtime showtime5 = new Showtime(movie5, LocalDateTime.of(2023, 7, 1, 19, 0), 100);
        Showtime showtime6 = new Showtime(movie6, LocalDateTime.of(2023, 7, 1, 20, 0), 100);
        Showtime showtime7 = new Showtime(movie7, LocalDateTime.of(2023, 7, 1, 21, 0), 100);
        Showtime showtime8 = new Showtime(movie8, LocalDateTime.of(2023, 7, 1, 22, 0), 100);
        Showtime showtime9 = new Showtime(movie9, LocalDateTime.of(2023, 7, 1, 23, 0), 100);
        Showtime showtime10 = new Showtime(movie10, LocalDateTime.of(2023, 7, 1, 00, 0), 100);



        showtimes.addAll(Arrays.asList(showtime1, showtime2, showtime3, showtime4, showtime5, showtime6, showtime7, showtime8, showtime9, showtime10));
    }

    public void run() {
        while (true) {
            System.out.println("\nWELCOME TO OUR TICKET BOOKING SYSTEM. WHAT CAN I DO FOR YOU? (book, change, cancel, end)");
            System.out.print("Your option: ");
            String command = sc.nextLine().toLowerCase();

            switch (command) {
                case "book":
                    book();
                    break;
                case "change":
                    change();
                    break;
                case "cancel":
                    cancel();
                    break;
                case "end":
                    System.exit(0);
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }


    private void book() {
        System.out.println("FOR HOW MANY PEOPLE?");
        int amount = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("WHAT'S YOUR NAME?");
        String name = sc.nextLine();

        System.out.println("WHICH MOVIE WOULD YOU LIKE TO SEE?");
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.println((i + 1) + ". " + showtimes.get(i).getMovie().getTitle() + " at " + dtf.format(showtimes.get(i).getTime()));
        }

        int choice = sc.nextInt() - 1;
        sc.nextLine(); // Consume newline

        Showtime showtime = showtimes.get(choice);

        if (showtime.getAvailableTickets() < amount) {
            System.out.println("Not enough tickets available!");
            return;
        }


        seatArea = getSeatArea();
        double price = calculatePrice(seatArea);
        String bookingNumber = String.format("%04d", rand.nextInt(10000));

        // Notice that you are now passing in seatArea and price to the Ticket constructor
        Ticket ticket = new Ticket(name, amount, showtime.getMovie().getTitle(), showtime.getTime(), seatArea, price);

        System.out.println("YOUR TICKET WILL COST: " + ticket.getPrice() * amount); // Assuming getPrice() returns the price for one ticket

        System.out.println("CONFIRM BOOKING? (yes/no)");
        String confirm = sc.nextLine().toLowerCase();

        if (confirm.equals("yes")) {
            bookingNumber = String.format("%04d", rand.nextInt(10000));
            tickets.put(bookingNumber, ticket);
            showtime.decreaseAvailableTickets(amount);

            System.out.println("SUCCESSFULLY BOOKED FOR:");
            System.out.println("Name: " + name);
            System.out.println("Number of people: " + amount);
            System.out.println("Movie: " + showtime.getMovie().getTitle());
            System.out.println("Time: " + dtf.format(showtime.getTime()));
            System.out.println("Seat Area: " + seatArea); // Print the selected seat area
            System.out.println("Booking number: " + bookingNumber);
        }
    }

    private String getSeatArea() {
        String seatArea = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("WHERE WOULD YOU LIKE TO SIT? (front: €10, middle: €20, back: €15)");
            seatArea = sc.nextLine().toLowerCase();
            if (seatArea.equals("front") || seatArea.equals("middle") || seatArea.equals("back")) {
                validInput = true;
            } else {
                System.out.println("Invalid seat area. Please choose 'front', 'middle' or 'back'.");
            }
        }
        return seatArea;
    }




    private void change() {
        System.out.println("WHAT'S YOUR BOOKING NUMBER?");
        String bookingNumber = sc.nextLine();

        if (!tickets.containsKey(bookingNumber)) {
            System.out.println("Invalid booking number!");
            return;
        }

        Ticket ticket = tickets.get(bookingNumber);

        System.out.println("WHICH MOVIE WOULD YOU LIKE TO SEE?");
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.println((i + 1) + ". " + showtimes.get(i).getMovie().getTitle() + " at " + dtf.format(showtimes.get(i).getTime()));
        }

        int choice = sc.nextInt() - 1;
        sc.nextLine(); // Consume newline

        Showtime newShowtime = showtimes.get(choice);

        if (newShowtime.getAvailableTickets() < ticket.getAmount()) {
            System.out.println("Not enough tickets available!");
            return;
        }

        System.out.println("CONFIRM CHANGES? (yes/no)");
        String confirm = sc.nextLine().toLowerCase();

        if (confirm.equals("yes")) {
            ticket.setMovie(newShowtime.getMovie().getTitle());
            ticket.setTime(newShowtime.getTime());
            newShowtime.decreaseAvailableTickets(ticket.getAmount());
            System.out.println("SUCCESSFULLY CHANGED THE BOOKING FOR:");
            System.out.println("Booking number: " + bookingNumber);
        }

        // String seatArea = getSeatArea();
        double price = calculatePrice(seatArea);

        // Notice that you are now passing in seatArea and price to the Ticket constructor
        ticket.setMovie(newShowtime.getMovie().getTitle());
        ticket.setTime(newShowtime.getTime());
        ticket.setSeatArea(seatArea);
        ticket.setPrice(price);
    }

    private double calculatePrice(String seatArea) {
        return 0;
    }

    private void cancel() {
        System.out.println("WHAT'S YOUR BOOKING NUMBER?");
        String bookingNumber = sc.nextLine();

        if (!tickets.containsKey(bookingNumber)) {
            System.out.println("Invalid booking number!");
            return;
        }

        System.out.println("ARE YOU SURE YOU WANT TO CANCEL THE BOOKING? (yes/no)");
        String confirm = sc.nextLine().toLowerCase();

        if (confirm.equals("yes")) {
            tickets.remove(bookingNumber);
            System.out.println("SUCCESSFULLY CANCELED THE BOOKING!");
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        tbs.run();
    }
    
}
