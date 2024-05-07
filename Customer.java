import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental( Rental arg) {
        _rentals.addElement(arg);
    }
    public Vector getRental(){
        return  _rentals;
    }
    public String getName (){
        return _name;
    }
    private double getTotalCharge()
    {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            result += aRental.getCharge();            
        }
        return result;
    }
    private int getFrequentRenterPoints()
    {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            result += aRental.getFrequentRenterPoints();            
        }
        return result;
    }
    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) +"\n";
        
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        System.out.println(result);
        return result;
    }
    public String htmlstatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements() ) {
            Rental aRental = (Rental) rentals.nextElement();
            //show figures for this rental
            result += aRental.getMovie().getTitle()+ ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +"</EM><P>\n";
        
        result += "On this rental you earned <EM>" + String.valueOf(getFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
}