import java.util.Enumeration;

public class HtmlStatement extends Statement
{
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
    public String headerString(Customer aCustomer) 
    {   
        return "<H1>Rental Record for <EM>" + aCustomer.getName() + "</EM> </H1> <P>\n" ;
    }
         
    public String eachRentalString(Rental aRental) 
    {
        return aRental.getMovie().getTitle() + ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
    }
     
    public String footerString(Customer aCustomer) 
    {
        return "<P> You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
            "On this rental you earned <EM> " + String.valueOf(aCustomer.getFrequentRenterPoints()) +
            " </EM> frequent renter points <P>";
    } 
}
