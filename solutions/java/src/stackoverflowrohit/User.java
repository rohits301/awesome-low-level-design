package stackoverflowrohit;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final String username;

    public User(String username){
        this.id = idCounter.getAndIncrement();
        this.username = username;
    }

    // Getter
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                '}';
    }
}
