import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Guest bookingGuest; //jméno hosta
    private List<Guest> otherGuests; //jména dalších hostů
    private Room bookingRoom; //číslo pokoje
    private LocalDate startDate; //začátek rezervace
    private LocalDate endDate; //konec rezervace
    private boolean isBusiness; //pracovní = true

    //konstruktor 1
    public Booking(Guest bookingGuest, List<Guest> otherGuests, Room bookingRoom, LocalDate startDate, LocalDate endDate, boolean isBusiness){
        this.bookingGuest = bookingGuest;
        this.otherGuests = otherGuests;
        this.bookingRoom = bookingRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBusiness = isBusiness;


    }

    //konstruktor 2
    public Booking(Guest bookingGuest, Room bookingRoom, LocalDate startDate, LocalDate endDate, boolean isBusiness) {
        this.bookingGuest = bookingGuest;
        otherGuests = new ArrayList<>();
        this.bookingRoom = bookingRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBusiness = isBusiness;
    }

    public static int getBookingLength(Booking booking) {
        int numberOfNights = (int) ChronoUnit.DAYS.between(booking.startDate, booking.endDate);
        return numberOfNights;
    }

    public static void printBookingLength(Booking booking) {
        int numberOfNights = (int) ChronoUnit.DAYS.between(booking.startDate, booking.endDate);
        System.out.println("Celkový počet nocí: " + numberOfNights);
    }

    public static void getPrice(Booking booking) {
        BigDecimal totalPrice = BigDecimal.valueOf(getBookingLength(booking)).multiply(booking.getBookingRoom().getRoomPrice());
        System.out.println("Celková cena za rezervaci: " + totalPrice);
    }

    public Guest getBookingGuest() {
        return bookingGuest;
    }

    public void setBookingGuest(Guest bookingGuest) {
        this.bookingGuest = bookingGuest;
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public Room getBookingRoom() {
        return bookingRoom;
    }

    public void setBookingRoom(Room bookingRoom) {
        this.bookingRoom = bookingRoom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }



    @Override
    public String toString() {
        return "Booking: " +
                "Guest(" + bookingGuest + ")" +
                ", other Guests(" + otherGuests + ")" +
                ", Room(" + bookingRoom + ")" +
                ", start Date(" + startDate + ")" +
                ", end Date(" + endDate + ")" +
                ", is Business(" + isBusiness + ")";
    }
}
