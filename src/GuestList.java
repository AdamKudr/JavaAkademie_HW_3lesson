import java.util.ArrayList;
import java.util.List;

public class GuestList {
        private List<Guest> guestList;

        public GuestList() {
            this.guestList = new ArrayList<>();
        }

        public void addGuest(Guest guest) {
            guestList.add(guest);
        }

        public void displayGuests() {
            for (Guest guest : guestList) {
                System.out.println(guest);
            }
        }
    }
