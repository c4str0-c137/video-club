import java.util.Enumeration;
import java.util.Vector;
class Rental {
    private Movie _movie;
    private Customer _customer;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented () {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }
    public String statement(Customer _customer) {
        double totalAmount = 0;
        
        int frequentRenterPoints = 0; 
        Enumeration rentals = _customer.getRental().elements();
        String result = "Rental Record for " + _customer.getName() + "\n";
        while (rentals.hasMoreElements() ) {
            double thisAmount = 1;
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
        
        // add frequent renter points
        frequentRenterPoints ++;
        // add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
            frequentRenterPoints ++;
        //show figures for this rental
        result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(thisAmount) + "\n";
        totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
        
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        System.out.println(result);
        return result;
    }
}