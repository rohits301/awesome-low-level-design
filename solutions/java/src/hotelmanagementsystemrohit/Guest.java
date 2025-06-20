package hotelmanagementsystemrohit;

import java.util.concurrent.atomic.AtomicInteger;

public class Guest {
    private final static AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private String guestName;
    private int numberInParty;
    private String contactInfo;

    public Guest(String guestName, int numberInParty, String contactInfo){
        this.id = idCounter.getAndIncrement();
        this.guestName = guestName;
        this.numberInParty = numberInParty;
        this.contactInfo = contactInfo;
    }
}