package stackoverflowrohit;

import java.util.ArrayList;
import java.util.List;

/**
 * We make an abstract class so that -
 */
public abstract class VoteableCommentable {
    protected List<Vote> voteList = new ArrayList<>();
    protected List<Comment> commentList = new ArrayList<>();

    public void castVote(Vote vote){
        voteList.add(vote);
    }

    public List<Vote> getVotes(){
        return voteList;
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }

}
