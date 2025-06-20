package stackoverflowrohit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Answer extends VoteableCommentable {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final String content;
    private final User author;
//    private List<Comment> commentList;
    // private List<Vote> voteList;

    // constructor
    public Answer(String content, User author){
        this.id = idCounter.getAndIncrement();
        this.author = author;
        this.content = content;
    }

    public int getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", commentList=" + commentList +
                ", voteList=" + voteList +
                '}';
    }
}
