package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductListDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProductList(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProductList(req,resp);
    }
    protected void doProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null) {
            id = "0";
        }
        Integer category = Integer.parseInt(id);
        ProductDao productDao = new ProductDao();
        List<ProductListDto> productList = productDao.productList(category);
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("views/productlist.jsp").forward(req, resp);
        System.out.println(
                "post 실행됨!!"
        );
        System.out.println(id);
    }

}
