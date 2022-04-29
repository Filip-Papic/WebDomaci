package rs.raf.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "submitClanovi", value = "/submitClanovi")
public class SubmitFormClanovi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestamp = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        String fileName = "tim_" + req.getSession().getAttribute("teamName") + timestamp;
        File file = new File("D:\\Desktop\\WebDomaci\\WebDomaci5\\", fileName);
        file.createNewFile();
        FileWriter fw = new FileWriter(file);

        fw.write("----------------------TIM:----------------------\n");
        fw.write("Ime tima: " + req.getSession().getAttribute("teamName") + "\n");
        fw.write("Email: " + req.getSession().getAttribute("email") + "\n");
        fw.write("Telefon: " + req.getSession().getAttribute("phone") + "\n");
        fw.write("Moto: " + req.getSession().getAttribute("moto") + "\n");
        fw.write("Kako su saznali: " + req.getSession().getAttribute("heardFrom") + "\n");
        fw.write("Veličina tima: " + req.getSession().getAttribute("teamSize") + "\n\n\n");
        fw.write("--------------------ČLANOVI:--------------------\n");
        for(int i = 1; i < (int)req.getSession().getAttribute("teamSize")+1; i++) {
            fw.write("Ime: " + req.getParameter("memberName"+i) + "\n");
            fw.write("Prezime: " + req.getParameter("memberLastname"+i) + "\n");
            fw.write("Email: " + req.getParameter("memberEmail"+i) + "\n");
            fw.write("Uloga: " + req.getParameter("memberRole"+i) + "\n\n");
        }
        fw.close();
        req.getSession().setAttribute("valid", "true");
        resp.sendRedirect("hvala-na-prijavi.jsp");
    }
}
