import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RentalTest {
    
    @Test
    public void testStatementhtml() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.REGULAR);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 2);
        Rental rental2 = new Rental(movie2, 3);
        customer.addRental(rental1);
        customer.addRental(rental2);
        String expectedStatement = "<H1>Rental Record for <EM>John Doe</EM> </H1> <P>\n" +
                                    "The Godfather: 2.0<BR>\n" +
                                    "Inception: 9.0<BR>\n" +
                                    "<P> You owe <EM>11.0</EM><P>\n" +
                                    "On this rental you earned <EM> 3 </EM> frequent renter points <P>";
        assertEquals(expectedStatement, customer.htmlstatement());
    }
    @Test
    public void testStatement2html() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.REGULAR);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 23);
        customer.addRental(rental1);
        customer.addRental(rental2);
        String expectedStatement = "<H1>Rental Record for <EM>John Doe</EM> </H1> <P>\n" +
                                    "The Godfather: 14.0<BR>\n" +
                                    "Inception: 69.0<BR>\n" +
                                    "<P> You owe <EM>83.0</EM><P>\n" +
                                    "On this rental you earned <EM> 3 </EM> frequent renter points <P>";
        assertEquals(expectedStatement, customer.htmlstatement());
    }
    @Test
    public void testStatement3html() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.CHILDRENS);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("Inception", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 23);
        Rental rental3 = new Rental(movie3, 8);
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        String expectedStatement = "<H1>Rental Record for <EM>John Doe</EM> </H1> <P>\n" +
                                    "The Godfather: 12.0<BR>\n" +
                                    "Inception: 69.0<BR>\n" +
                                    "Inception: 11.0<BR>\n" +
                                    "<P> You owe <EM>92.0</EM><P>\n" +
                                    "On this rental you earned <EM> 4 </EM> frequent renter points <P>";
        assertEquals(expectedStatement, customer.htmlstatement());
    }
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
        assertEquals(expectedStatement, customer.statement());
    }
    @Test
    public void testStatement2() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.REGULAR);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 23);
        customer.addRental(rental1);
        customer.addRental(rental2);
        String expectedStatement = "Rental Record for John Doe\n" +
                                    "\tThe Godfather\t14.0\n" +
                                    "\tInception\t69.0\n" +
                                    "Amount owed is 83.0\n" +
                                    "You earned 3 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }
    @Test
    public void testStatement3() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("The Godfather", Movie.CHILDRENS);
        Movie movie2 = new Movie("Inception", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("Inception", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 23);
        Rental rental3 = new Rental(movie3, 8);
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        String expectedStatement = "Rental Record for John Doe\n" +
                                    "\tThe Godfather\t12.0\n" +
                                    "\tInception\t69.0\n" +
                                    "\tInception\t11.0\n" +
                                    "Amount owed is 92.0\n" +
                                    "You earned 4 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }
}

