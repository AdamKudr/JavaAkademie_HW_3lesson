import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GuestList guestList = new GuestList();

        Guest guest1 = new Guest("Adela", "Malikova", LocalDate.of(1993,03,13));
        guestList.addGuest(guest1);
        Guest guest2 = new Guest("Jan", "Dvoracek", LocalDate.of(1995, 05, 05));
        guestList.addGuest(guest2);

        RoomList roomList = new RoomList();

        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000.00));
        roomList.addRoom(room1);
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000.00));
        roomList.addRoom(room2);
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400.00));
        roomList.addRoom(room3);

        BookingList bookingList = new BookingList();

        Booking booking1 = new Booking(guest1, room1, LocalDate.of(2021, 7, 21), LocalDate.of(2021, 7, 26), true);
        bookingList.addBooking(booking1);
        Booking booking2 = new Booking(guest2, guest1, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), false);
        bookingList.addBooking(booking2);
        Booking booking3 = new Booking(guest1, guest2, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), false);
        bookingList.addBooking(booking3);
        Booking booking4 = new Booking(guest2, room3, LocalDate.of(2021, 10, 1), LocalDate.of(2021, 10, 12), true);
        bookingList.addBooking(booking4);


        guestList.displayGuests();
        roomList.displayRooms();
        bookingList.displayBookings();


        
    }
}