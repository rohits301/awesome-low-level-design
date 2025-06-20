package stackoverflowrohit;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Comment {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    // WE MAKE THE BELOW FIELDS FINAL
    // STRING - IMMUTABLE, LocalDateTime - IMMUTABLE
    // USER - ONLY REFERENCE IS IMMUTABLE, CAN MODIFY THE VALUES OF FIELDS IN THE UESR OBJECT.
    // hence, make final
    private final String content;
    private final User author;
    private final LocalDateTime creationDate;

    // constructor
    public Comment (String content, User author){
        this.id = idCounter.getAndIncrement();
        this.content = content;
        this.author = author;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", creationDate=" + creationDate +
                '}';
    }
}
