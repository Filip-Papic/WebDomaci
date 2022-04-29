package rs.raf.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "submitTim", value = "/submitTim")
public class SubmitFormTim extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String teamName = req.getParameter("teamName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String moto = req.getParameter("moto");
        String heardFrom = req.getParameter("heardFrom");
        int teamSize = Integer.parseInt(req.getParameter("teamSize"));

        req.getSession().setAttribute("teamName", teamName);
        req.getSession().setAttribute("email", email);
        req.getSession().setAttribute("phone", phone);
        req.getSession().setAttribute("moto", moto);
        req.getSession().setAttribute("heardFrom", heardFrom);
        req.getSession().setAttribute("teamSize", teamSize);

        resp.sendRedirect("prijavaClanova.jsp");
    }
}
