import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Adela", "Malikova", LocalDate.of(1993,03,13));
        Guest guest2 = new Guest("Jan", "Dvoracek", LocalDate.of(1995, 05, 05));

        List<Guest> Guestlist = new ArrayList<>();
        Guestlist.add(guest1);
        Guestlist.add(guest2);

        for (Guest guest : Guestlist) {  // cyklus "for-each"
            System.out.println(guest.getFirstName() + " " + guest.getLastName() + " " + guest.getDateOfBirth());
        }

        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000.00));
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000.00));
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400.00));

        List<Room> Roomlist = new ArrayList<>();
        Roomlist.add(room1);
        Roomlist.add(room2);
        Roomlist.add(room3);

        for (Room room : Roomlist) {  // cyklus "for-each"
            System.out.println("Room number: " + room.getRoomNumber() + ", Capacity: " + room.getRoomBeds() + ", Price: " + room.getRoomPrice() + ", Balcony: " + room.isRoomBalcony() + ", Sea view: " + room.isRoomSeaView());
        }

        BookingList bookingList = new BookingList();

        Booking booking1 = new Booking(guest1, room1, LocalDate.of(2021, 7, 21), LocalDate.of(2021, 7, 26), true);
        bookingList.addBooking(booking1);
        Booking booking2 = new Booking(guest2, guest1, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), false);
        bookingList.addBooking(booking2);
        Booking booking3 = new Booking(guest1, guest2, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), false);
        bookingList.addBooking(booking3);
        Booking booking4 = new Booking(guest2, room3, LocalDate.of(2021, 10, 1), LocalDate.of(2021, 10, 12), true);
        bookingList.addBooking(booking4);
        
        bookingList.displayBookings();


        
    }
}