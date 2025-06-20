package hotelmanagementsystemrohit;

import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private RoomType roomType;
    private RoomStatus roomStatus; // occupied or available
    private double pricePerNight;

    public Room(RoomType roomType, RoomStatus roomStatus, double pricePerNight){
        this.id = idCounter.getAndIncrement();
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.pricePerNight = pricePerNight;
    }

    // Getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}

// Booking, Guest, Admin(hotel management system),
// Room, RoomType, RoomStatus
// Hotel
// Hotel has many rooms.
// 1 room belongs to 1 hotel.
// Room can have many guests
// 1 guest can have 1 room
// booking can have one or more guests, one or more rooms
//
// methods - checkin, checkout, booking,

