package com.playdata.kiosk.servlet;

import com.playdata.kiosk.utility.kitchen.OrderBoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        new OrderBoardService().알바야주문번호확인해라();
        req.getRequestDispatcher("views/orderboard.jsp").forward(req, resp);
    }
}
