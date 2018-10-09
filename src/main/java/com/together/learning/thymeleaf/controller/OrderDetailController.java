package com.together.learning.thymeleaf.controller;

import com.together.learning.thymeleaf.service.OrderService;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangjian
 */
public class OrderDetailController implements IController {


    public OrderDetailController() {
        super();
    }


    @Override
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("order", new OrderService().findById(Integer.valueOf(request.getParameter("orderId"))));
        templateEngine.process("order/detail", ctx, response.getWriter());

    }

}
