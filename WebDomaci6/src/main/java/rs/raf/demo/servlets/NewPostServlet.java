package rs.raf.demo.servlets;

import rs.raf.demo.models.Post;
import rs.raf.demo.repository.posts.IPostRepository;
import rs.raf.demo.repository.posts.InMemoryPostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewPostServlet", value = "/new-post")
public class NewPostServlet extends HttpServlet {

    private IPostRepository postRepository;

    @Override
    public void init() {
        //super.init();
        this.postRepository = new InMemoryPostRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/new-post.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //super.doPost(req, resp);
        String author = req.getParameter("postAuthor");
        int id = InMemoryPostRepository.id;
        String title = req.getParameter("postTitle");
        String content = req.getParameter("postContent");

        Post post = new Post(author, id , title, content);
        postRepository.insert(post);

        resp.sendRedirect(getServletContext().getContextPath() + "/posts");
    }
}
