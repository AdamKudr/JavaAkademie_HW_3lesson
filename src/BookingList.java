import java.util.ArrayList;
import java.util.List;

public class BookingList {
    private List<Booking> bookings;

    public BookingList() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
