package ru.otus.homework.servlet;

import com.google.gson.Gson;
import ru.otus.homework.crm.model.Client;
import ru.otus.homework.crm.service.DBServiceClient;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class ClientApiServlet extends HttpServlet {

    private final DBServiceClient clientService;
    private final Gson gson;
    private final Map<String, Function<HttpServletRequest, ?>> pathHandlers;

    public ClientApiServlet(DBServiceClient clientService, Gson gson) {
        this.clientService = clientService;
        this.gson = gson;

        pathHandlers = new HashMap<>() {
            {
                put("GET", (req) -> clientService.findAll());
            }

            {
                put("POST", (req) -> {
                    try (BufferedReader reader = req.getReader()) {
                        Client clientReq = gson.fromJson(reader, Client.class);
                        return clientService.saveClient(clientReq);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                });
            }
        };
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        simpleExecute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        simpleExecute(request, response);
    }

    protected void simpleExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Function<HttpServletRequest, ?> f = pathHandlers.get(request.getMethod());
        Object res = f.apply(request);

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(gson.toJson(res));
    }
}
