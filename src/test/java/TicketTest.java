import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void testTicketConstructorAndMethods() {

        Ticket ticket = new Ticket("John Doe", 2, "The Dark Knight", LocalDateTime.now(), "middle", 20.0);

        // Teste getName-Methode
        assertEquals("John Doe", ticket.getName());

        // Teste getAmount-Methode
        assertEquals(2, ticket.getAmount());

        // Teste getMovie-Methode
        assertEquals("The Dark Knight", ticket.getMovie());

        // Teste getSeatArea-Methode
        assertEquals("middle", ticket.getSeatArea());

        // Teste getPrice-Methode
        assertEquals(20.0, ticket.getPrice());


        ticket.setMovie("Inception");
        ticket.setTime(LocalDateTime.now());
        ticket.setSeatArea("back");

        assertEquals("Inception", ticket.getMovie());
        assertEquals("back", ticket.getSeatArea());

        // Teste calculatePrice-Methode
        assertEquals(15.0, ticket.calculatePrice());
    }
}
