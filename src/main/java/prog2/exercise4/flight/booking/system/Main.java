package prog2.exercise4.flight.booking.system;

/**
 * Hello world!
 *
 */
/**
 * Hello world!
 *
 */
import java.util.Scanner;
import java.time.LocalDate;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your full name: ");
        String name = s.nextLine();
        FlightBooking customer = new FlightBooking("null", null, null, 0, 0);

        System.out.println("Please enter your dedparture time[yyyy-MM-dd]:");
        String sdepart = s.nextLine();
        LocalDate date1 = LocalDate.parse(sdepart);
        System.out.println("Please enter your return time[yyyy-MM-dd]:");
        String sreturn = s.nextLine();
        LocalDate date2 = LocalDate.parse(sreturn);

        String tn = "11FASDFDOM";
        
        System.out.println("Please enter the number of the child: ");
        int child = s.nextInt();
        System.out.println("Please enter the number of the adult: ");
        int adult = s.nextInt();
        
        s.nextLine();
        System.out.println("Please select your seat:");
        System.out.println("1. First");
        System.out.println("2. Business");
        System.out.println("3. Economy");
        String a = s.nextLine();
        
        System.out.println("Please select your trip type:");
        System.out.println("1. One way");
        System.out.println("2. Return");
        String b = s.nextLine();

        System.out.println("Please select your trip source:");
        System.out.println("1. Nanjing");
        System.out.println("2. Beijing");
        System.out.println("3. Oulu");
        System.out.println("4. Helsinki");
        String c = s.nextLine();

        System.out.println("Please select your trip destination:");
        System.out.println("1. Nanjing");
        System.out.println("2. Beijing");
        System.out.println("3. Oulu");
        System.out.println("4. Helsinki");
        String d = s.nextLine();
        
        customer.setBookingClass(a);
        customer.setTripType(b);
        customer.setTripSource(c);
        customer.setTripDestination(c, d);
        customer.setDaysToAdd(date1, date2);
        customer.setDepartureDate(date1);
        customer.setReturnDate(date2);
        customer.setTicketNumber(tn);
        
        customer.setPassengerFullName(name);
        customer.setChildPassengers(child);
        customer.setAdultPassengers(adult);
        customer.setTotalPassengers(customer.getAdultPassengers(), customer.getChildPassengers());
        customer.setDepartingTicketPrice(child, adult);
        customer.setReturnTicketPrice();
        customer.setTotalTicketPrice();
        customer.setTicketNumber();
       
        System.out.println(customer);
        s.close();
    }
}

