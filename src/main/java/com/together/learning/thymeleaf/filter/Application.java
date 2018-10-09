package com.together.learning.thymeleaf.filter;

import com.together.learning.thymeleaf.controller.*;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjian
 */
public class Application {
    private final TemplateEngine templateEngine;
    private Map<String, IController> controllersByURL;


    public Application(final ServletContext servletContext) {

        super();

        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver(servletContext);

        // HTML is the default mode, but we set it anyway for better understanding of code
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // This will convert "home" to "/WEB-INF/templates/home.html"
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Template cache TTL=1h. If not set, entries would be cached until expelled
//        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

        // Cache is set to true by default. Set to false if you want templates to
        // be automatically updated when modified.
        templateResolver.setCacheable(false);

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);

        this.controllersByURL = new HashMap<>();
        this.controllersByURL.put("/", new HomeController());
        this.controllersByURL.put("/subscribe", new SubscribeController());
        this.controllersByURL.put("/product/list", new ProductListController());
        this.controllersByURL.put("/product/comments", new CommentController());
        this.controllersByURL.put("/order/list", new OrderController());
        this.controllersByURL.put("/order/detail", new OrderDetailController());
        this.controllersByURL.put("/test/context", new TestContextController());


    }

    public IController resolveControllerForRequest(HttpServletRequest request) {
        return this.controllersByURL.get(getRequestPath(request));
    }



    private static String getRequestPath(final HttpServletRequest request) {

        String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();

        final int fragmentIndex = requestURI.indexOf(';');
        if (fragmentIndex != -1) {
            requestURI = requestURI.substring(0, fragmentIndex);
        }

        if (requestURI.startsWith(contextPath)) {
            return requestURI.substring(contextPath.length());
        }
        return requestURI;
    }


    public ITemplateEngine getTemplateEngine() {
        return this.templateEngine;
    }
}
