import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental( Rental arg) {
        _rentals.addElement(arg);
    }
    public Enumeration getRentals() {
        return _rentals.elements();
    }
    public String getName (){
        return _name;
    }
    public double getTotalCharge()
    {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            result += aRental.getCharge();            
        }
        return result;
    }
    public int getFrequentRenterPoints()
    {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            result += aRental.getFrequentRenterPoints();            
        }
        return result;
    }
    public String htmlstatement() {
        return new HtmlStatement().value(this);
    }
    public String statement()
    {
        return new TextStatement().value(this);
    }
}