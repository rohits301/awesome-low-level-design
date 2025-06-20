package stackoverflowrohit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverflowSystem {

    // Maps are needed to ensure we have an efficient lookup of system-wide users, questions, answers, tags
    Map<Integer, User> users = new HashMap<>();
    Map<Integer, Question> questions = new HashMap<>();
    Map<Integer, Answer> answers = new HashMap<>();
    Map<String, Tag> tags = new HashMap<>(); // to make sure only one tag of particular name exists globally

    // simulate APIs
    public User createUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String title, String content, User author, List<String> tagsList){
        Question question = new Question(title, content, author);
        // map tags to question
        for(String name: tagsList){
            Tag tag = tags.computeIfAbsent(name, n -> new Tag(n));
            question.addTag(tag);
        }
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(Question question, String content, User author){
        Answer answer = new Answer(content, author);
        // map answer to question
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment postCommentToQuestion(Question question, String content, User author){
        Comment comment = new Comment(content, author);

        question.addComment(comment);
        // Here, we don't need to add the updated `question` to `Map<> questions` because
        // map stores the reference for the objects, so they are updated implicitly
        return comment;
    }

    public Comment postCommentToAnswer(Answer answer, String content, User author){
        Comment comment = new Comment(content, author);

        answer.addComment(comment);
        return comment;
    }

    public void upvoteQuestion(Question question, User votedBy){
        Vote vote = new Vote(votedBy, VoteType.UPVOTE);
        question.castVote(vote);
    }

    public void downvoteAnswer(Answer answer, User votedBy){
        Vote vote = new Vote(votedBy, VoteType.DOWNVOTE);
        answer.castVote(vote);
    }
}
