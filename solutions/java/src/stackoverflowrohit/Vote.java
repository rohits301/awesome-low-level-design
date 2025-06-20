package stackoverflowrohit;

import java.util.concurrent.atomic.AtomicInteger;

public class Vote {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final User votedBy;
    private final VoteType voteType;

    // ctor

    public Vote(User votedBy, VoteType voteType) {
        this.id = idCounter.getAndIncrement();
        this.votedBy = votedBy;
        this.voteType = voteType;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", votedBy=" + votedBy +
                ", voteType=" + voteType +
                '}';
    }
}
