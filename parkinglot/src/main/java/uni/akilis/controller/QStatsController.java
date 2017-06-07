package uni.akilis.controller;

import java.io.BufferedReader;
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
        urlPatterns={"/showTableClientSide.do",
                "/showTableServerSide.do",
        "/showColumnCategories.do",
        "/showReport.do"}
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
        String url = req.getRequestURI().substring(req.getContextPath().length());;
        LoggerX.println("Request URI: " + url);
        String rst = new String();
        if ("/showTableClientSide.do".equalsIgnoreCase(url)) {
            LoggerX.println("doGet: showTableClientSide");
            String tableName = req.getParameter("name");
            //        String rst = new GsonBuilder().setPrettyPrinting().create().toJson(this.qStatsDAO.getTableRecords(tableName));
            rst = this.qStatsDAO.getTable(tableName);
        }
        else if ("/showColumnCategories.do".equalsIgnoreCase(url)) {
            LoggerX.println("doGet: showColumnCategories");
            String tableName = req.getParameter("tableName");
            String colName = req.getParameter("colName");
            LoggerX.println("Table: " + tableName + ", column: " + colName);
            rst = this.qStatsDAO.getColumnCategories(tableName, colName);

        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(rst);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // According to the URL in request, do query or statistics respectively.
        String url = req.getRequestURI().substring(req.getContextPath().length());;
        LoggerX.println("Request URI: " + url);
        String rst = new String();
        if ("/showTableServerSide.do".equalsIgnoreCase(url)) {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) { /*report an error*/ }
            LoggerX.println("Content: " + jb.toString());
            rst = this.qStatsDAO.getTableRecordsServerSide(jb.toString());
        }
        else if ("/showReport.do".equalsIgnoreCase(url)) {
            // TODO
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(rst);
        out.flush();
    }



}
