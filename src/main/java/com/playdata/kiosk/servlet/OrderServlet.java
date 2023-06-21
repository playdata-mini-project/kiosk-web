package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.OrderDao;
import com.playdata.kiosk.dto.ProductCartDto;
import com.playdata.kiosk.utility.kitchen.OrderBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();
        OrderBoardService orderBoardService = new OrderBoardService();

        HttpSession session = req.getSession();
        List<ProductCartDto> cartList = (List<ProductCartDto>) session.getAttribute("cartList");
        if(cartList == null) {
            cartList = new ArrayList<>();
        }
        Long userId = (Long) session.getAttribute("id");
        int orderHistoryId = orderDao.orderSave(userId);
        for(int i = 0; i<cartList.size(); i++ ) {
            Long productId = cartList.get(i).getId();
            int quantity = cartList.get(i).getQuantity();
            String userName = (String) session.getAttribute("name");
            orderDao.order(productId,quantity);
            orderDao.orderDetailSave(orderHistoryId,productId,quantity);
            orderBoardService.알바야커피만들어라(productId,quantity,userName);
        }
        session.removeAttribute("cartList");
        resp.sendRedirect("/orderboard");

    }
}
