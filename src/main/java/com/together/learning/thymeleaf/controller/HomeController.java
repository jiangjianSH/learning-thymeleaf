package com.together.learning.thymeleaf.controller;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * @author jiangjian
 */
public class HomeController implements IController {


    public HomeController() {
        super();
    }


    @Override
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("today", Calendar.getInstance());
        ctx.setVariable("hasError", true);
        ctx.setVariable("grade", 90);
        templateEngine.process("home", ctx, response.getWriter());

    }

}
