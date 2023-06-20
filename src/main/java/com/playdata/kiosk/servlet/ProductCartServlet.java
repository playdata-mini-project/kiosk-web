package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dto.ProductCartDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/productcart")
public class ProductCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        List<ProductCartDto> cartList = (List<ProductCartDto>) session.getAttribute("cartList");
        req.setAttribute("cartList",cartList);
        System.out.println(cartList);
        req.getRequestDispatcher("views/productcart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        Long productId = Long.valueOf(req.getParameter("id"));
        String productName = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        int priceTotal = price * quantity;

        HttpSession session = req.getSession();
        List<ProductCartDto> cartList = (List<ProductCartDto>) session.getAttribute("cartList");
        if(cartList == null) {
            cartList = new ArrayList<>();
        }

        String status = null;

        for(int i = 0; i<cartList.size(); i++ ) {
            Long cartId = cartList.get(i).getId();
            if(cartId == productId && cartId != null) {
                cartList.get(i).setQuantity(
                        cartList.get(i).getQuantity() + quantity
                );
                status = "duplicate";
            }
        }

        cartList.add(new ProductCartDto(productId,productName,quantity,price,priceTotal));

        if(status == "duplicate") {
            cartList.remove(cartList.size()-1);
        }

        session.setAttribute("cartList",cartList);
        System.out.println(cartList);
        resp.sendRedirect("/product");
    }
}
