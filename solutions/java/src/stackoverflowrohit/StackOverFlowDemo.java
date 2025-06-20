package stackoverflowrohit;

import java.util.List;

public class StackOverFlowDemo {
    public static void main(String[] args) {
        StackOverflowSystem system = new StackOverflowSystem();

        User alice = system.createUser("Alice");
        User bob = system.createUser("Bob");

        Question q1 = system.postQuestion("What is LLD?", "Can someone explain LLD?", alice, List.of("design", "architecture"));

        Answer a1 = system.postAnswer(q1, "LLD is about class-level design.", bob);

        system.postCommentToQuestion(q1, "Thanks Bob!", alice);
        system.postCommentToAnswer(a1, "You're welcome!", bob);

        system.upvoteQuestion(q1, bob);
        system.upvoteQuestion(q1, bob);
        system.downvoteAnswer(a1, alice);

        System.out.println("Question: " + q1.getTitle() + " has " + q1.getVotes().size() + " votes");
        System.out.println("Answer: " + a1.getContent() +  " has " + a1.getVotes().size() + " votes");
    }
}
