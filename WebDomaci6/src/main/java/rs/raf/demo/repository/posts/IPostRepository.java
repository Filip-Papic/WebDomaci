package rs.raf.demo.repository.posts;

import rs.raf.demo.models.Post;

import java.util.List;

public interface IPostRepository {
    public List<Post> all();
    public Post getPost(int postID);
    public void insert(Post post);
}
