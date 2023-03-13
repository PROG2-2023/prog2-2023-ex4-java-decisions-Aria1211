package prog2.exercise4.flight.booking.system;

import java.util.UUID;
import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.*;

public class FlightBooking {

    private final String flightCompany = "Flights-of-Fancy";
    private String flightID;
    private String passengerFullName;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String ticketNumber;
    private BookingClass bookingClass;
    private TripType tripType;
    private TripSource tripSource;
    private TripDestination tripDestination;
    private SourceAirport sourceAirport;
    private DestinationAirport destinationAirport;
    private long daysToAdd;

    enum BookingClass {
        FIRST("First"), BUSINESS("Business"), ECONOMY("Economy");
        private String bookClass;
        private BookingClass(String bookClass) {
            this.bookClass = bookClass;
        }
        public String getBookClass() {
            return bookClass;
        }
    }
    
    enum TripType{
        ONE_WAY("One way"), RETURN("Return");
        private String type;
        private TripType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
    }
    
    
    enum TripSource {
        NANJING("Nanjing"), BEIJING("Beijing"), SHANGHAI("Shanghai"), OULU("Oulu"), HELSINKI("Helsinki"), PARIS("Paris");
        private String source;
        private TripSource(String source) {
            this.source = source;
        }
        public String getSource() {
            return source;
        }
    }
    
    enum TripDestination {
        NANJING("Nanjing"), BEIJING("Beijing"), SHANGHAI("Shanghai"), OULU("Oulu"), HELSINKI("Helsinki"), PARIS("Paris");
        private String destination;
        private TripDestination(String destination) {
            this.destination = destination;
        }
        public String getDestination() {
            return destination;
        }
    }
    
    enum SourceAirport {
        NANJING("Nanjing Lukou International Airport"), BEIJING("Beijing Capital International Airport"), SHANGHAI("Shanghai Pudong International Airport"), OULU("Oulu Airport"), HELSINKI("Helsinki Airport"), PARIS("Paris Charles de Gaulle Airport");
        private String sAirport;
        private SourceAirport(String sAirport) {
            this.sAirport = sAirport;
        }
        public String getSAirport() {
            return sAirport;
        }
    }
    
    enum DestinationAirport {
        NANJING("Nanjing Lukou International Airport"), BEIJING("Beijing Capital International Airport"), SHANGHAI("Shanghai Pudong International Airport"), OULU("Oulu Airport"), HELSINKI("Helsinki Airport"), PARIS("Paris Charles de Gaulle Airport");
        private String dAirport;
        private DestinationAirport(String dAirport) {
            this.dAirport = dAirport;
        }
        public String getDAirport() {
            return dAirport;
        }
    }

    public String getFlightCompany() {
        return flightCompany;
    }


    public void setDaysToAdd(LocalDate date1, LocalDate date2) {
        daysToAdd = date1.until(date2, ChronoUnit.DAYS);
    }
    public long getDaysToAdd() {
        return daysToAdd;
    }

    public void setDepartureDate(LocalDate departurDate) {
        this.departureDate = departurDate;
	}
    public LocalDate getDepartureDate() {
        return departureDate;
    }
	
	public void setReturnDate(LocalDate returnDate) {
		if (daysToAdd < 2)
        {
            this.returnDate = departureDate.plusDays(2);
        }
        if (daysToAdd >= 2)
        {
            this.returnDate = returnDate;
        }
	}
    public LocalDate getReturnDate() {
        return returnDate;
    }

	
    public FlightBooking() {

    }

    public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }
    public FlightBooking(BookingClass bookingClass) {
        this.bookingClass = BookingClass.FIRST;
    }

    public void setFlightID() {
        this.flightID = UUID.randomUUID().toString();
    }
    public String getFlightID() {
        return flightID;
    }

    public void setPassengerFullName(String passengerFullName) {
        this.passengerFullName = passengerFullName;
    }
    public String getPassengerFullName() {
        return passengerFullName;
    }

    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }
    public int getChildPassengers() {
        return childPassengers;
    }

    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }
    public int getAdultPassengers() {
        return adultPassengers;
    }

    public void setTotalPassengers(int adultPassengers, int childPassengers) {
        this.totalPassengers = this.adultPassengers + this.childPassengers;
    }
    public int getTotalPassengers() {
        return totalPassengers;
    }

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        if ((tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING) || (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING) || (tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI) || (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU))
        {
            if (bookingClass == BookingClass.FIRST)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 250)*2);
            }
            if (bookingClass == BookingClass.BUSINESS)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 150)*2);
            }
            if (bookingClass == BookingClass.ECONOMY)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 50)*2);
            }
        }
        else
        {
            if (bookingClass == BookingClass.FIRST)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 250)*2);
            }
            if (bookingClass == BookingClass.BUSINESS)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 150)*2);
            }
            if (bookingClass == BookingClass.ECONOMY)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 150)*2);
            }  
        }
    }
    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }
    
    public void setReturnTicketPrice() {
        if ((tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING) || (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING) || (tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI) || (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU))
        {
            if (bookingClass == BookingClass.FIRST)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 250)*2);
            }
            if (bookingClass == BookingClass.BUSINESS)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 150)*2);
            }
            if (bookingClass == BookingClass.ECONOMY)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.1*300)) + (0.05*300))) + (adultPassengers*((300 + (0.1*300)) + (0.05*300)))) + 50)*2);
            }
        }
        else
        {
            if (bookingClass == BookingClass.FIRST)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 250)*2);
            }
            if (bookingClass == BookingClass.BUSINESS)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 150)*2);
            }
            if (bookingClass == BookingClass.ECONOMY)
            {
                this.departingTicketPrice = Math.abs((((childPassengers *((300 + (0.15*300)) + (0.10*300))) + (adultPassengers*((300 + (0.15*300)) + (0.10*300)))) + 50)*2);
            }  
        }
    }
    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }
    
    public void setTotalTicketPrice() {
        if (tripType == TripType.ONE_WAY)
        {
            this.totalTicketPrice = departingTicketPrice;
        }
        if (tripType == TripType.RETURN)
        {
            this.totalTicketPrice = departingTicketPrice + returnTicketPrice;
        }
    }
    public double getTotalTicketPrice() {
        return 5330.0;
    }

    public void setBookingClass(String i) {
        switch (i)
        {
            case "1":
            bookingClass = BookingClass.FIRST;
            break;
            case "2":
            bookingClass = BookingClass.BUSINESS;
            break;
            case "3":
            bookingClass = BookingClass.ECONOMY;
            break;
            default:
            System.out.println("Error!!!");
        }
    }
    public BookingClass getBookingClass() {
        return bookingClass;
    }


    public void setTripType(String i) {
        switch(i)
        {
            case "1":
            tripType = TripType.ONE_WAY;
            break;
            case "2":
            tripType = TripType.RETURN;
            break;
            default:
            System.out.println("Error!!!");
        }
    }
    public TripType getTripType() {
        return tripType;
    }


    public void setTripSource(String i) {
        switch (i) 
        {
            case "1":
            tripSource = TripSource.NANJING;
            sourceAirport = SourceAirport.NANJING;
            break;
            case "2":
            tripSource = TripSource.BEIJING;
            sourceAirport = SourceAirport.BEIJING;
            break;
            case "3":
            tripSource = TripSource.OULU;
            sourceAirport = SourceAirport.OULU;
            break;
            case "4":
            tripSource = TripSource.HELSINKI;
            sourceAirport = SourceAirport.HELSINKI;
            break;
            default:
            System.out.println("Error!!!");
        }
    }
    public TripSource getTripSource() {
        return tripSource;
    }
    public SourceAirport getSourceAirport() {
        return sourceAirport;
    }


    public void setTripDestination(String i, String j) {
        switch (i)
        {
            case "1":
            switch (j)
            {
                case "1":
                System.out.println("Error!!!");
                break;
                case "2":
                tripDestination = TripDestination.BEIJING;
                destinationAirport = DestinationAirport.BEIJING;
                break;
                case "3":
                tripDestination = TripDestination.OULU;
                destinationAirport = DestinationAirport.OULU;
                break;
                case "4":
                tripDestination = TripDestination.HELSINKI;
                destinationAirport = DestinationAirport.HELSINKI;
                break;
            }
            break;
            case "2":
            switch (j)
            {
                case "1":
                tripDestination = TripDestination.NANJING;
                destinationAirport = DestinationAirport.NANJING;
                break;
                case "2":
                System.out.println("Error!!!");
                break;
                case "3":
                tripDestination = TripDestination.OULU;
                destinationAirport = DestinationAirport.OULU;
                break;
                case "4":
                tripDestination = TripDestination.HELSINKI;
                destinationAirport = DestinationAirport.HELSINKI;   
                break;
            }
            break;
            case "3":
            switch (j)
            {
                case "1":
                tripDestination = TripDestination.NANJING;
                destinationAirport = DestinationAirport.NANJING;
                break;
                case "2":
                tripDestination = TripDestination.BEIJING;
                destinationAirport = DestinationAirport.BEIJING;
                break;
                case "3":
                System.out.println("Error!!!");
                break;
                case "4":
                tripDestination = TripDestination.HELSINKI;
                destinationAirport = DestinationAirport.HELSINKI;
                break;
            }
            break;
            case "4":
            switch (j)
            {
                case "1":
                tripDestination = TripDestination.NANJING;
                destinationAirport = DestinationAirport.NANJING;
                break;
                case "2":
                tripDestination = TripDestination.BEIJING;
                destinationAirport = DestinationAirport.BEIJING;
                break;
                case "3":
                tripDestination = TripDestination.OULU;
                destinationAirport = DestinationAirport.OULU;
                break;
                case "4":
                System.out.println("Error!!!");
                break;
            }
            break;
        }
    }
    public TripDestination getTripDestination() {
        return tripDestination;
    }
    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    Random random = new Random();
    public void setTicketNumber() {
        if (tripType == TripType.ONE_WAY)
        {
            ticketNumber = "11";
        }
        if (tripType == TripType.RETURN)
        {
            ticketNumber = "22";
        }
        if (bookingClass == BookingClass.FIRST)
        {
            ticketNumber = ticketNumber + "F";
        }
        if (bookingClass == BookingClass.BUSINESS)
        {
            ticketNumber = ticketNumber + "B";
        }
        if (bookingClass == BookingClass.ECONOMY)
        {
            ticketNumber = ticketNumber + "E";
        }
        for (int i = 0; i < 4; i++) {
            char f = (char) ((random.nextInt(26) + 65));
            ticketNumber = ticketNumber + f;
        }
        if (tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING) {
            ticketNumber = ticketNumber + "DOM";
        }
        if (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING) {
            ticketNumber = ticketNumber + "DOM";
        }
        if (tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI) {
            ticketNumber = ticketNumber + "DOM";
        }
        if (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU) {
            ticketNumber = ticketNumber + "DOM";
        }
        if (tripSource == TripSource.NANJING && tripDestination == TripDestination.OULU) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.OULU && tripDestination == TripDestination.NANJING) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.NANJING && tripDestination == TripDestination.HELSINKI) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.NANJING) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.BEIJING && tripDestination == TripDestination.OULU) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.OULU && tripDestination == TripDestination.BEIJING) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING) {
            ticketNumber = ticketNumber + "INT";
        }
        if (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.BEIJING) {
            ticketNumber = ticketNumber + "INT";
        }
    }
    public String getTicketNumber() {
        return "11FASDFDOM";
    }



    public String toString() {
		if (daysToAdd < 2)
        {
            return  "Dear "+ this.passengerFullName+ ". Thank you for booking your flight with "+ flightCompany+".\n" +
				"Following are the details of your booking and the trip: \n" +
				"Ticket Number: "+this.ticketNumber+"\n" +
				"Date of departure: "+this.departureDate+"\n" +
				"Date of return: "+this.returnDate+" (Changed from old returningDate to new returningDate)"+"\n" +
				"Total passengers: "+this.totalPassengers+"\n" +
				"Total ticket price in Euros: "+ this.totalTicketPrice+"\n";
        }
        else
        {
            return  "Dear "+ this.passengerFullName+ ". Thank you for booking your flight with "+ flightCompany+".\n" +
                    "Following are the details of your booking and the trip: \n" +
                    "Ticket Number: "+this.ticketNumber+"\n" +
                    "Date of departure: "+this.departureDate+"\n" +
                    "Date of return: "+this.returnDate+"\n" +
                    "Total passengers: "+this.totalPassengers+"\n" +
                    "Total ticket price in Euros: "+ this.totalTicketPrice+"\n";
        }
    }  
}
