

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class RentalTest {
    
    @Test
    public void testStatement() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.REGULAR);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 2);
        Rental rental2 = new Rental(movie2, 3);
        customer.addRental(rental1);
        customer.addRental(rental2);
        String expectedStatement = "<H1>Rental Record for <EM>John Doe</EM></H1><P>\n" +
                                    "The Godfather: 2.0<BR>\n" +
                                    "Inception: 9.0<BR>\n" +
                                    "<P>You owe <EM>11.0</EM><P>\n" +
                                    "On this rental you earned <EM>3</EM> frequent renter points<P>";
        System.out.println(customer.htmlstatement());
        System.out.println(expectedStatement);
        assertEquals(expectedStatement, customer.htmlstatement());
    }
}

