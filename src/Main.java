import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuestList guestList = new GuestList();

        Guest guest1 = new Guest("Karel", "Dvorak", LocalDate.of(1990, 05, 15));
        guestList.addGuest(guest1);
        Guest guest2 = new Guest("Karel", "Dvorak", LocalDate.of(1979, 01, 03));
        guestList.addGuest(guest2);
        Guest guest3 = new Guest("Karolina", "Tmava", LocalDate.of(1989, 06, 05));
        guestList.addGuest(guest3);

        RoomList roomList = new RoomList();

        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000.00));
        roomList.addRoom(room1);
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000.00));
        roomList.addRoom(room2);
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400.00));
        roomList.addRoom(room3);

        BookingManager bookingManager = new BookingManager();

        fillBookings(guestList, roomList, bookingManager);
        System.out.println("--------------------");
        printBookings(bookingManager);
        System.out.println("--------------------");
        bookingManager.getNumberOfWorkingBookings();
        System.out.println("--------------------");
        bookingManager.getAverageGuests();
        System.out.println("--------------------");
        firstLeisureBookings(bookingManager, 8);
        System.out.println("--------------------");
        printGuestStatistics(bookingManager);
        System.out.println("--------------------");
        Booking.printBookingLength(bookingManager.getBooking(1));
        System.out.println("--------------------");
        Booking.getPrice(bookingManager.getBooking(1));

    }


    private static void fillBookings(GuestList guestList, RoomList roomList, BookingManager bookingManager) {
        bookingManager.addBooking(new Booking(guestList.getGuestList().get(0), List.of(guestList.getGuestList().get(1)), roomList.getRoomList().get(2), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), true));
        bookingManager.addBooking(new Booking(guestList.getGuestList().get(1), roomList.getRoomList().get(1), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), false));
        for (int i = 0; i <= 20; i = i + 2) {
            bookingManager.addBooking(new Booking(guestList.getGuestList().get(2), roomList.getRoomList().get(1), LocalDate.of(2023, 8, 1 + i), LocalDate.of(2023, 8, 2 + i), false));
        }
        bookingManager.addBooking(new Booking(guestList.getGuestList().get(2), roomList.getRoomList().get(2), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), false));
    }

    private static void printBookings(BookingManager bookingManager) {
        for (Booking booking : bookingManager.getBookings()) {
            System.out.println(booking.getStartDate() + " až " + booking.getEndDate() + ": "
                    + booking.getBookingGuest() + " (" + booking.getBookingGuest().getDateOfBirth() + ") "
                    + "[" + booking.getOtherGuests() + ", " + booking.getBookingRoom().isRoomSeaView() + "] za "
                    + booking.getBookingRoom().getRoomPrice());
        }
    }

    private static void firstLeisureBookings(BookingManager bookingManager, int limit) {
        int i = 0;
        System.out.println("Prvních " + limit + " volnočasových rezervací");
        for (Booking booking : bookingManager.getBookings()) {
            if (!booking.isBusiness() && i != limit) {
                i++;
                System.out.println(i);
                System.out.println(booking.getStartDate() + " až " + booking.getEndDate() + ": "
                        + booking.getBookingGuest() + " (" + booking.getBookingGuest().getDateOfBirth() + ") "
                        + "[" + booking.getOtherGuests() + ", " + booking.getBookingRoom().isRoomSeaView() + "] za "
                        + booking.getBookingRoom().getRoomPrice());
            } else if (i == limit) break;
            else continue;
        }
    }

    private static void printGuestStatistics(BookingManager bookingManager) {
        int oneGuestBooking = 0;
        int twoGuestBooking = 0;
        int moreGuestsBooking = 0;
        for (Booking booking : bookingManager.getBookings()) {
            int totalGuestsPerBooking = 1 + booking.getOtherGuests().size();
            if (totalGuestsPerBooking == 1) {
                oneGuestBooking++;
            } else if (totalGuestsPerBooking == 2) {
                twoGuestBooking++;
            } else moreGuestsBooking++;
        }
        System.out.println("Počet rezervací s jedním hostem je: " + oneGuestBooking);
        System.out.println("Počet rezervací se dvěma hosty je: " + twoGuestBooking);
        System.out.println("Počet rezervací s více než dvěma hosty je: " + moreGuestsBooking);
    }
}