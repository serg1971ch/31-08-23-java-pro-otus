package ru.otus.homework.servlet;

import ru.otus.homework.crm.model.Address;
import ru.otus.homework.crm.model.Client;
import ru.otus.homework.crm.model.Phone;
import ru.otus.homework.crm.service.DBServiceClient;
import ru.otus.homework.services.TemplateProcessor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ClientsServlet extends HttpServlet {


    private static final String PARAM_NAME = "name";
    private static final String PARAM_ADDRESS = "address";
    private static final String PARAM_PHONE = "phone";

    private static final String CLIENTS_PAGE_TEMPLATE = "clients.html";
    private static final String CLIENT_PAGE_TEMPLATE = "client.html";

    private final DBServiceClient clientService;
    private final TemplateProcessor templateProcessor;

    public ClientsServlet(TemplateProcessor templateProcessor, DBServiceClient clientService) {
        this.templateProcessor = templateProcessor;
        this.clientService = clientService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

        Map<String, Object> clientMap = new HashMap<>();
        String path = req.getServletPath();
        String page;
        if (path.contains("clients")) {
            List<PlainClient> clients = clientService.findAll().stream().map(PlainClient::new).collect(Collectors.toList());
            clientMap.put("clients", clients);
            page = CLIENTS_PAGE_TEMPLATE;
        } else {
            page = CLIENT_PAGE_TEMPLATE;
        }
        response.setContentType("text/html");
        response.getWriter().println(templateProcessor.getPage(page, clientMap));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter(PARAM_NAME);
        if (name == null || name.isEmpty()) {
            response.sendRedirect("/clients");
            return;
        }
        String address = request.getParameter(PARAM_ADDRESS);
        String phone = request.getParameter(PARAM_PHONE);

        Client clientResp = new Client(name, new Address(null, address), List.of(new Phone(null, phone)));
        clientService.saveClient(clientResp);
        response.sendRedirect("/clients");
    }

    public static class PlainClient {
        private final Client client;

        public PlainClient(Client client) {
            this.client = client;
        }

        public Long getId() {
            return client.getId();
        }


        public String getName() {
            return client.getName();
        }


        public String getAddress() {
            return client.getAddress() == null ? "empty_street" : client.getAddress().getStreet();
        }

        public String getPhone() {
            return client.getPhones() != null && client.getPhones().size() > 0 ? client.getPhones().get(0).getNumber() : "empty_phone";
        }
    }
}
