package hotelmanagementsystemrohit;

import java.time.LocalDate;

public class HotelManagementDemo {
    /**
     * Note:
     * “I used synchronized booking to ensure only one thread books at a time.
     * Availability is checked using date overlaps.
     * I maintain thread-safe data structures using ConcurrentHashMap.
     * Room state is updated accordingly, and canceled bookings are marked, not deleted, which helps retain booking history.”
     *
     * And then optionally:
     *
     * “To scale this further, I would break the lock scope down to per-room locking,
     * or use database row-level locking if persisted.”
     *
     */
    public static void main(String[] args) {
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();

        Room room1 = new Room(RoomType.STANDARD, RoomStatus.AVAILABLE, 235.89);
        Room room2 = new Room(RoomType.DELUXE, RoomStatus.AVAILABLE, 535.89);
        Room room3 = new Room(RoomType.DELUXE, RoomStatus.AVAILABLE, 535.89);
        Room room4 = new Room(RoomType.SUITE, RoomStatus.AVAILABLE, 635.89);

        hotelManagementSystem.allRooms.put(room1.getId(), room1);
        hotelManagementSystem.allRooms.put(room2.getId(), room2);
        hotelManagementSystem.allRooms.put(room3.getId(), room3);
        hotelManagementSystem.allRooms.put(room4.getId(), room4);

        Guest guest1 = new Guest("Rohit", 3, "rohit@gmail.com");

        Guest guest2 = new Guest("Sachdeva", 2, "sachdeva@gmail.com");

        LocalDate checkinDate1 = LocalDate.now().minusDays(3);
        LocalDate checkoutDate1 = LocalDate.now();


        LocalDate checkinDate2 = LocalDate.now();
        LocalDate checkoutDate2 = LocalDate.now().plusDays(2);

        String confirmationNumber1 = hotelManagementSystem.createBooking(1, guest1, RoomType.STANDARD, checkinDate1, checkoutDate1);

        String confirmationNumber2 = hotelManagementSystem.createBooking(2, guest2, RoomType.DELUXE, checkinDate2, checkoutDate2);

        Booking canceledBooking = hotelManagementSystem.cancelBooking(confirmationNumber1);
        System.out.println("Confirmation Number1: " + confirmationNumber1);
        System.out.println("Confirmation Number2: " + confirmationNumber2);
        System.out.println("Cancelled bookings: " + canceledBooking.getConfirmationNumber());
    }
}
