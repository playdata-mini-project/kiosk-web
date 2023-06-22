package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dto.ProductCartDto;
import com.playdata.kiosk.dto.ProductCartListDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/productcart")
public class ProductCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();

        ProductCartListDto cartList = (ProductCartListDto) session.getAttribute("cartList");
        req.setAttribute("cartList",cartList);
        req.getRequestDispatcher("views/productcart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        Long productId = Long.valueOf(req.getParameter("id"));
        String productName = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String image = req.getParameter("image");
        int price = Integer.parseInt(req.getParameter("price"));
        int priceTotal = price * quantity;

        HttpSession session = req.getSession();
        ProductCartListDto cartListDto = (ProductCartListDto) session.getAttribute("cartList");

        if (cartListDto == null) {
            cartListDto = new ProductCartListDto();
        }

        cartListDto.addCartList(new ProductCartDto(
                productId, productName, quantity, price, priceTotal, image)
        );

        session.setAttribute("cartList",cartListDto);
        resp.sendRedirect("/product");
    }
}
