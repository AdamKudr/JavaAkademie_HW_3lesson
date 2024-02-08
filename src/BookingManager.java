import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;
    private int numberOfWorkingBookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }

    public Booking getBooking(int index) {
        System.out.println(bookings.get(index));
        return bookings.get(index);
    }

    public List<Booking> getBookings() {
        return bookings;
        }

    public void clearBookings() {
        bookings.clear();
    }

    public void getNumberOfWorkingBookings() {
        for (Booking booking : bookings) {
            if (booking.isBusiness()) {
                numberOfWorkingBookings++;
            }
        }
        System.out.println("Celkový počet pracovních pobytů: " + numberOfWorkingBookings);
    }

    public double getNumberOfGuests() {
        double numberOfGuests = 0;
        for (Booking booking : bookings) {
            numberOfGuests += 1 + booking.getOtherGuests().size();
        }
        return numberOfGuests;
    }
    public void getAverageGuests() {
        double averageGuests = getNumberOfGuests() / bookings.size();
        System.out.println("Průměrná obsazenost pokoje: " + averageGuests);

        }

    }
