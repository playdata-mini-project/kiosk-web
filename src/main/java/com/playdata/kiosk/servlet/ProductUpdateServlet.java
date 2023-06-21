package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/addProductUpdate")
public class ProductUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int addQuantity = Integer.parseInt(req.getParameter("addQuantity"));

        ProductDto productDto = new ProductDto(id, quantity, addQuantity);
        ProductDao productDao = new ProductDao();
        productDao.updateProductQuantity(productDto);
        resp.sendRedirect("/productlist");
    }
}
