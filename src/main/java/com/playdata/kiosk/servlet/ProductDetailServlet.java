package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductDetailDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productdetail")
public class ProductDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("흠");
        String id = req.getParameter("id");
        System.out.println(id);
        ProductDao productDao = new ProductDao();
        ProductDetailDto productDetail = productDao.productDetail(Long.valueOf(id));
        System.out.println(productDetail+"test");
        req.setAttribute("productDetail",productDetail);
        req.getRequestDispatcher("views/productdetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
