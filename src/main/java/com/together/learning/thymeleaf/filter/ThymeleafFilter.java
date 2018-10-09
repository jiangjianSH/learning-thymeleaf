package com.together.learning.thymeleaf.filter;

import com.together.learning.thymeleaf.controller.IController;
import com.together.learning.thymeleaf.entity.User;
import org.thymeleaf.ITemplateEngine;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author jiangjian
 */
@WebFilter("/*")
public class ThymeleafFilter implements Filter {
    private ServletContext servletContext;
    private Application application;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        servletContext.setAttribute("author", "jiangjian");
        application = new Application(filterConfig.getServletContext());
    }

    private static void addUserToSession(final HttpServletRequest request) {
        // Simulate a real user session by adding a user object
        request.getSession(true).setAttribute("user", new User("John", "Apricot", "Antarctica", null));
        request.getSession(true).setAttribute("randomValue", new Random().nextLong());
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        addUserToSession((HttpServletRequest)servletRequest);
        if (!process((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    private boolean process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        try {

            // This prevents triggering engine executions for resource URLs
            if (request.getRequestURI().startsWith("/css") ||
                    request.getRequestURI().startsWith("/images") ||
                    request.getRequestURI().startsWith("/favicon")) {
                return false;
            }


            /*
             * Query controller/URL mapping and obtain the controller
             * that will process the request. If no controller is available,
             * return false and let other filters/servlets process the request.
             */
            IController controller = this.application.resolveControllerForRequest(request);
            if (controller == null) {
                return false;
            }

            /*
             * Obtain the TemplateEngine instance.
             */
            ITemplateEngine templateEngine = this.application.getTemplateEngine();

            /*
             * Write the response headers
             */
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            /*
             * Execute the controller and process view template,
             * writing the results to the response writer.
             */
            controller.process(
                    request, response, this.servletContext, templateEngine);

            return true;

        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (final IOException ignored) {
                // Just ignore this
            }
            throw new ServletException(e);
        }

    }
}
