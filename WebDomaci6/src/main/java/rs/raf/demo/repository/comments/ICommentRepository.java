package rs.raf.demo.repository.comments;

import rs.raf.demo.models.Comment;

import java.util.List;

public interface ICommentRepository {
    public List<Comment> allId(int id);

    public void insert(Comment comment);
}
