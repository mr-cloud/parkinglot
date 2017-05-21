package uni.akilis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
        urlPatterns={"/login.do"}
        )
public class Login extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print("{\"name\":\"admin\", \"passwd\":123456}");
        out.flush();
    }

}
