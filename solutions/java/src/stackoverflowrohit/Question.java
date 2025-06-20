package stackoverflowrohit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Question extends VoteableCommentable {
    private static AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private String title; // can make final since Question is not editable right now
    // but in case, we make it editable later, remove final
    private String content; // same for content
    private final User author;
    private List<Answer> answerList = new ArrayList<>();
//    private List<Comment> commentList;
//    private List<Vote> voteList;
    private final List<Tag> tagList = new ArrayList<>(); // adding final prevents re-assignment

    // constructor

    public Question(String title, String content, User author) {
        this.id = idCounter.getAndIncrement();
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public int getId(){
        return this.id;
    }

    public List<Tag> getTags(){
        return this.tagList;
    }

    public void addTag(Tag tag){
        tagList.add(tag);
    }

    public void addAnswer(Answer answer){
        answerList.add(answer);
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", answerList=" + answerList +
                ", commentList=" + commentList +
                ", tagList=" + tagList +
                ", voteList=" + voteList +
                '}';
    }
}
