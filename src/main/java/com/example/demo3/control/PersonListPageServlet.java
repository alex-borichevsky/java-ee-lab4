package com.example.demo3.control;

import com.example.demo3.dao.DBConnection;
import com.example.demo3.dao.DefaultStudentDao;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "startServlet", value = "/start")
public class PersonListPageServlet extends HttpServlet {


    private DefaultStudentDao personDao;

    @Override
    public void init() throws ServletException {
        personDao = DefaultStudentDao.getInstance(DBConnection.getConnection());
        super.init();
    }

    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null) {
            request.setAttribute("count", personDao.count());
        }
        request.setAttribute("students", personDao.getAllStudents());
        request.getRequestDispatcher(ServletConstants.INDEX_PAGE).forward(request, response);
    }
}