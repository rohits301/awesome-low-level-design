package stackoverflowrohit;

import java.util.concurrent.atomic.AtomicInteger;

public class Tag {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private String name;

    // ctor

    public Tag(String name) {
        this.id = idCounter.getAndIncrement();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
