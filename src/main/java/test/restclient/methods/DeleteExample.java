package test.restclient.methods;

import org.springframework.web.client.RestTemplate;

public class DeleteExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final Long ID = 110L;

    private static final String URL = "http://localhost:8080/rest/" + ID;

    public static void main(String[] args) {
        REST_TEMPLATE.delete(URL);
    }
}
