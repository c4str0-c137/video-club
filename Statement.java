import java.util.Enumeration;

public abstract class Statement {
    public String value(Customer aCustomer) {
    
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for each rental
            result += eachRentalString(each);
        } // fin while
        //add footer lines
        result += footerString(aCustomer); 
        
        return result;
    }
    abstract String headerString(Customer aCustomer);
    abstract String eachRentalString(Rental aRental);
    abstract String footerString(Customer aCustomer);
}
