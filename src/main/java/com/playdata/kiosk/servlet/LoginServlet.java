package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.UserDao;
import com.playdata.kiosk.domain.Role;
import com.playdata.kiosk.domain.User;
import com.playdata.kiosk.dto.LoginDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        LoginDto loginDto = new LoginDto(name, password);
        User user = new UserDao().login(loginDto);

        if(user == null){
            resp.sendRedirect("/login");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("name", user.getName());
            session.setAttribute("role", user.getRole());

            if(user.getRole() == Role.ADMIN){
                resp.sendRedirect("order");
            } else {
                resp.sendRedirect("admin");
            }
        }

    }
}
