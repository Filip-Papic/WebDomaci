package rs.raf.demo.servlets;

import rs.raf.demo.repository.posts.IPostRepository;
import rs.raf.demo.repository.posts.InMemoryPostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostsServlet", value = {"/posts", "/"})
public class PostsServlet extends HttpServlet {

    private IPostRepository postRepository;

    @Override
    public void init() {
        this.postRepository = new InMemoryPostRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setAttribute("posts", this.postRepository.all());

        req.getRequestDispatcher("/posts.jsp").forward(req, resp);
    }
}
