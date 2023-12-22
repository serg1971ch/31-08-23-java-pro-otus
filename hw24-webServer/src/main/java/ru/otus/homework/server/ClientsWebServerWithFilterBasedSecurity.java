package ru.otus.homework.server;

import com.google.gson.Gson;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.otus.homework.crm.service.DBServiceClient;
import ru.otus.homework.services.TemplateProcessor;
import ru.otus.homework.services.UserAuthService;
import ru.otus.homework.servlet.AuthorizationFilter;
import ru.otus.homework.servlet.LoginServlet;

import java.util.Arrays;

public class ClientsWebServerWithFilterBasedSecurity extends ClientsWebServerSimple {
    private final UserAuthService authService;

    public ClientsWebServerWithFilterBasedSecurity(int port,
                                                   UserAuthService authService,
                                                   DBServiceClient clientService,
                                                   Gson gson,
                                                   TemplateProcessor templateProcessor) {
        super(port, clientService, gson, templateProcessor);
        this.authService = authService;
    }

    @Override
    protected Handler applySecurity(ServletContextHandler servletContextHandler, String... paths) {
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet(templateProcessor, authService)), "/login");
        AuthorizationFilter authorizationFilter = new AuthorizationFilter();
        Arrays.stream(paths).forEachOrdered(path -> servletContextHandler.addFilter(new FilterHolder(authorizationFilter), path, null));
        return servletContextHandler;
    }
}
