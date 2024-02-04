import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private List<Room> roomList;

    public RoomList() {
        this.roomList = new ArrayList<>();
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void displayRooms() {
        for (Room room : roomList) {
            System.out.println(room);
        }
    }
}
