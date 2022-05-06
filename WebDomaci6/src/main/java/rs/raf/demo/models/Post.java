package rs.raf.demo.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private String author;
    private int postID;
    private String title;
    private String content;
    private Date createdDate;
    //private LocalDate createdDate;

    public Post(String author, int postID, String title, String content) {
        this.author = author;
        this.postID = postID;
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
    }

    public String getAuthor() {
        return author;
    }

    public int getPostID() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
