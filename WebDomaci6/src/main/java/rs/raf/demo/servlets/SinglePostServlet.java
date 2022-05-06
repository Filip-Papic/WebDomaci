package rs.raf.demo.servlets;

import rs.raf.demo.models.*;
import rs.raf.demo.repository.comments.ICommentRepository;
import rs.raf.demo.repository.comments.InMemoryCommentRepository;
import rs.raf.demo.repository.posts.IPostRepository;
import rs.raf.demo.repository.posts.InMemoryPostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinglePostsServlet", value = "/posts/*")
public class SinglePostServlet extends HttpServlet {

    private IPostRepository postRepository;
    private ICommentRepository commentRepository;

    @Override
    public void init() {
        postRepository = new InMemoryPostRepository();
        commentRepository = new InMemoryCommentRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println(req.getPathInfo());
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        Post post = this.postRepository.getPost(id);
        List<Comment> commentList = commentRepository.allId(id);
        req.setAttribute("post", post);
        req.setAttribute("commentList", commentList);

        req.getRequestDispatcher("/single-post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //super.doPost(req, resp);
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        String name = req.getParameter("commentName");
        String body = req.getParameter("commentBody");
        Comment comment = new Comment(id, name, body);
        this.commentRepository.insert(comment);

        resp.sendRedirect(getServletContext().getContextPath() + "/posts/" + id);
    }
}
