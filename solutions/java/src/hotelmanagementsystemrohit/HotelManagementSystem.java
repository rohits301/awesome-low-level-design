package hotelmanagementsystemrohit;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    Map<Integer, Room> allRooms; // roomId, room
    Map<Integer, List<Booking>> roomBookings; // roomId, roomBookings
    Map<String, Booking> allBookings;

    public HotelManagementSystem() {
        this.allRooms = new ConcurrentHashMap<>();
        this.roomBookings = new ConcurrentHashMap<>();
        this.allBookings = new ConcurrentHashMap<>();
    }

    // search for available rooms
    public List<Room> findAvailableRooms(RoomType roomType, LocalDate checkinDate, LocalDate checkoutDate) {
        List<Room> availableRooms = new ArrayList<>();
        for (Map.Entry<Integer, Room> entry : allRooms.entrySet()) {
            Room room = entry.getValue();
            if (room.getRoomType() == roomType && isAvailable(room, checkinDate, checkoutDate)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private boolean isAvailable(Room room, LocalDate checkinDate, LocalDate checkoutDate) {
        // if there is no booking for this room for these dates
        // no booking for the particular dates
        List<Booking> bookings = roomBookings.getOrDefault(room.getId(), new ArrayList<>());
        for (Booking b : bookings) {
            if (!(checkoutDate.isBefore(b.getCheckinDate()) || checkinDate.isAfter(b.getCheckoutDate()))) {
                return false;
            }
        }
        return true;
    }

    // perform booking
    public synchronized String createBooking(int roomCount, Guest guest, RoomType roomType, LocalDate checkinDate, LocalDate checkoutDate) {
        List<Room> availableRooms = findAvailableRooms(roomType, checkinDate, checkoutDate);
        // check availability
        if (availableRooms.size() < roomCount) {
            throw new RuntimeException("Rooms not available");
        }

        // assign rooms
        List<Room> assignedRooms = availableRooms.subList(0, roomCount);

        Booking booking = new Booking();
        booking.setGuest(guest);
        booking.setCheckinDate(checkinDate);
        booking.setCheckoutDate(checkoutDate);
        booking.setRooms(assignedRooms);
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setConfirmationNumber("CONF#" + booking.getId());

        allBookings.put(booking.getConfirmationNumber(), booking);

        // Link booking to each room’s booking list
        for (Room room : assignedRooms) {
            roomBookings.computeIfAbsent(room.getId(), k -> new ArrayList<>()).add(booking);
            room.setRoomStatus(RoomStatus.OCCUPIED);
        }

        return booking.getConfirmationNumber();
    }

    public Booking cancelBooking(String confirmationNumber) {
        Booking booking = allBookings.get(confirmationNumber);
        if (booking == null || booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Invalid or already cancelled booking.");
        }

        booking.setBookingStatus(BookingStatus.CANCELLED);

        for (Room room : booking.getRooms()) {
            room.setRoomStatus(RoomStatus.AVAILABLE);
            List<Booking> bookings = roomBookings.get(room.getId());
            bookings.remove(booking);  // remove by reference
        }
        return booking;
    }
}
