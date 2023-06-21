package com.playdata.kiosk.servlet;

import com.playdata.kiosk.utility.kitchen.OrderBoardService;
import com.playdata.kiosk.utility.kitchen.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderboard")
public class OrderBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Orders>[] lists = new OrderBoardService().알바야주문번호확인해라();
        req.setAttribute("complete" , lists[0]);
        req.setAttribute("incomplete" , lists[1]);
        req.getRequestDispatcher("views/orderboard.jsp").forward(req, resp);
        for(int i=0;i< lists.length; i++) {
            System.out.println(i+"test------");
            List list1 = lists[i];
            for (Object o : list1) {
                System.out.println(o.toString()+"--- object");
            }
        }
    }
}
