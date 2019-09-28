package test.restclient.methods;

import org.springframework.web.client.RestTemplate;
import test.restclient.model.User;

public class PutExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final Long ID = 110L;
    private static final String LOGIN = "1";
    private static final String PASSWORD = "u";
    private static final String NAME = "u";

    private static final String URL = "http://localhost:8080/rest";

    public static void main(String[] args) {
        User user = new User(ID, LOGIN, PASSWORD, NAME);

        REST_TEMPLATE.put(URL, user);
    }
}
