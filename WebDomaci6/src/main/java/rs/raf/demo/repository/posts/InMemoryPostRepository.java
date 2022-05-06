package rs.raf.demo.repository.posts;

import rs.raf.demo.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPostRepository implements IPostRepository{
    private static final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    public static int id = 1;

    @Override
    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public void insert(Post post) {
        posts.put(id, post);
        id++;
    }

    @Override
    public Post getPost(int id) {
        return posts.get(id);
    }
}
