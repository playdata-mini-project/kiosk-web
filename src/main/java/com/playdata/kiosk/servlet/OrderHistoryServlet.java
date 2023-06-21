package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.OrderHistoryDao;
import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.OrderHistoryDto;
import com.playdata.kiosk.dto.ProductDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/orderHistoryList")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        List<OrderHistoryDto> list = new OrderHistoryDao().findAll();
        req.setAttribute("orderHistoryList", list);
        req.getRequestDispatcher("views/orderHistoryList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
