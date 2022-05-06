package rs.raf.demo.repository.comments;

import rs.raf.demo.models.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryCommentRepository implements ICommentRepository{
    private static final List<Comment> comments = new CopyOnWriteArrayList<>();

    @Override
    public List<Comment> allId(int id) {
        List<Comment> commentList = new ArrayList<>();
        comments.iterator().forEachRemaining(e -> {
            if(e.getPostID() == id){
                commentList.add(e);
            }
        });

        return commentList;
    }

    @Override
    public void insert(Comment comment) {
        comments.add(comment);
    }
}
