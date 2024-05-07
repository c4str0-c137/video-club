

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
        String expectedStatement = "Rental Record for John Doe\n" +
                                    "\tThe Godfather\t2.0\n" +
                                    "\tInception\t9.0\n" +
                                    "Amount owed is 11.0\n" +
                                    "You earned 3 frequent renter points";
        System.out.println(customer.statement());
        assertEquals(expectedStatement, customer.statement());
    }
}

