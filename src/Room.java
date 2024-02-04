import java.math.BigDecimal;

public class Room {

    private int roomNumber;
    private int roomBeds;
    private boolean roomBalcony;
    private boolean roomSeaView;
    private BigDecimal roomPrice;

    //kontruktor
    public Room(int roomNumber, int roomBeds, boolean roomBalcony, boolean roomSeaView, BigDecimal roomPrice) {
        this.roomNumber = roomNumber;
        this.roomBeds = roomBeds;
        this.roomBalcony = roomBalcony;
        this.roomSeaView = roomSeaView;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomBeds() {
        return roomBeds;
    }

    public void setRoomBeds(int roomBeds) {
        this.roomBeds = roomBeds;
    }

    public boolean isRoomBalcony() {
        return roomBalcony;
    }

    public void setRoomBalcony(boolean roomBalcony) {
        this.roomBalcony = roomBalcony;
    }

    public boolean isRoomSeaView() {
        return roomSeaView;
    }

    public void setRoomSeaView(boolean roomSeaView) {
        this.roomSeaView = roomSeaView;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return  "Number " + roomNumber +
                ", Beds " + roomBeds +
                ", Balcony " + roomBalcony +
                ", Sea view " + roomSeaView +
                ", Price " + roomPrice;
    }
}
