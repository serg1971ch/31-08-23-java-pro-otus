package ru.otus.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.cfg.Configuration;
import ru.otus.homework.core.repository.DataTemplateHibernate;
import ru.otus.homework.core.repository.HibernateUtils;
import ru.otus.homework.core.sessionmanager.TransactionManagerHibernate;
import ru.otus.homework.crm.dbmigrations.MigrationsExecutorFlyway;
import ru.otus.homework.crm.model.Address;
import ru.otus.homework.crm.model.Client;
import ru.otus.homework.crm.model.Phone;
import ru.otus.homework.crm.service.DBServiceClient;
import ru.otus.homework.crm.service.DbServiceClientImpl;
import ru.otus.homework.server.ClientsWebServer;
import ru.otus.homework.server.ClientsWebServerWithFilterBasedSecurity;
import ru.otus.homework.services.SuperSimpleUserAuthService;
import ru.otus.homework.services.TemplateProcessor;
import ru.otus.homework.services.TemplateProcessorImpl;
import ru.otus.homework.services.UserAuthService;
//import ru.otus.services.*;

/*
    Полезные для демо ссылки

    // Стартовая страница
    http://localhost:8080

    // Страница пользователей
    http://localhost:8080/users

    // REST сервис
    http://localhost:8080/api/user/3
*/
public class WebServerWithFilterBasedSecurityDemo {
    private static final int WEB_SERVER_PORT = 8080;
    private static final String TEMPLATES_DIR = "/templates/";
    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) throws Exception {
        DBServiceClient serviceClient = getClientService();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        TemplateProcessor templateProcessor = new TemplateProcessorImpl(TEMPLATES_DIR);
        UserAuthService authService = new SuperSimpleUserAuthService();

        ClientsWebServer clientsWebServer = new ClientsWebServerWithFilterBasedSecurity(WEB_SERVER_PORT,
                authService, serviceClient, gson, templateProcessor);

        clientsWebServer.start();
        clientsWebServer.join();
    }

    private static DBServiceClient getClientService() {
        var configuration = new Configuration().configure(HIBERNATE_CFG_FILE);

        var dbUrl = configuration.getProperty("hibernate.connection.url");
        var dbUserName = configuration.getProperty("hibernate.connection.username");
        var dbPassword = configuration.getProperty("hibernate.connection.password");

        new MigrationsExecutorFlyway(dbUrl, dbUserName, dbPassword).executeMigrations();

        var sessionFactory = HibernateUtils.buildSessionFactory(configuration, Client.class, Address.class, Phone.class);

        var transactionManager = new TransactionManagerHibernate(sessionFactory);

        var clientTemplate = new DataTemplateHibernate<>(Client.class);

        return new DbServiceClientImpl(transactionManager, clientTemplate);
    }
}
