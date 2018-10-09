package com.together.learning.thymeleaf.controller;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangjian
 */
public class TestContextController implements IController {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {
        WebContext webContext = new WebContext(request, response, servletContext, request.getLocale());
        webContext.setVariable("c1", "c1Value");
        templateEngine.process("test/context", webContext, response.getWriter());
    }
}
