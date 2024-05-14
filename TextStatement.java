import java.util.Enumeration;

public class TextStatement extends Statement{
    public String value(Customer acustomer)
    {
        Enumeration rentals = acustomer.getRentals();
        String result = headerString(acustomer);
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            //show figures for this rental
            result += eachRentalString(aRental);
        }
        result += footerString(acustomer);
        return result;
    }
    public String headerString(Customer aCustomer)
    {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }
    public String eachRentalString(Rental aRental)
    {
        return "\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n";
    }
    public String footerString(Customer aCustomer)
    {
        return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) +"\n" + 
        "You earned " + String.valueOf(aCustomer.getFrequentRenterPoints()) + " frequent renter points";
    }
}
