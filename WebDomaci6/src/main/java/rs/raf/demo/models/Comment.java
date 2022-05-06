package rs.raf.demo.models;

public class Comment {
    private int postID;
    private String name;
    private String body;

    public Comment(int postID, String name, String body) {
        this.postID = postID;
        this.name = name;
        this.body = body;
    }

    public int getPostID() {
        return postID;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }
}
