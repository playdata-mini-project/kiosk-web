package com.playdata.kiosk.servlet;

import com.playdata.kiosk.dao.ProductDao;
import com.playdata.kiosk.dto.ProductDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(200);
        request.getRequestDispatcher("views/addProduct.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        int makeTime = Integer.parseInt(req.getParameter("makeTime"));
        String imgUrl = req.getParameter("imgUrl");
        ProductDto productDto = new ProductDto(name, categoryId, quantity, price, makeTime, imgUrl);
        ProductDao productDao = new ProductDao();
        productDao.insert(productDto);

        resp.sendRedirect("/addproduct");
    }
}
