package uni.akilis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

import uni.akilis.dao.QStatsDAO;
import uni.akilis.dao.QStatsDAOImpl;
import uni.akilis.helper.LoggerX;

@WebServlet(
        urlPatterns={"/showTableClientSide.do"}
        )
public class QStatsController extends HttpServlet{
    private QStatsDAO qStatsDAO;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.qStatsDAO = new QStatsDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoggerX.println("doGet: showTableClientSide");
        String tableName = req.getParameter("name");
//        String jsonTable = new GsonBuilder().setPrettyPrinting().create().toJson(this.qStatsDAO.getTableRecords(tableName));
        String jsonTable = this.qStatsDAO.getTable(tableName);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonTable);
        out.flush();
    }

    
}
