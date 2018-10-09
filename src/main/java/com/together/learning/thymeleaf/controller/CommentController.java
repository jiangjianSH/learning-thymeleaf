package com.together.learning.thymeleaf.controller;

import com.together.learning.thymeleaf.entity.Product;
import com.together.learning.thymeleaf.service.ProductService;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;

/**
 * @author jiangjian
 */
public class CommentController implements IController {


    public CommentController() {
        super();
    }


    @Override
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {
        ProductService productService = new ProductService();
        Integer prodId = Integer.valueOf(request.getParameter("prodId"));
        Product product = productService.findById(prodId);
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("product", product);
        templateEngine.process("product/comments", ctx, response.getWriter());
    }

}
