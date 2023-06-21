package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.UserDao;
import com.playdata.kiosk.dto.JoinDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/join.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");

        JoinDto joinDto = new JoinDto(name, password, mail);
        new UserDao().join(joinDto);

        resp.sendRedirect("/login");
    }
}
