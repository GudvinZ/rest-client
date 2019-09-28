package test.restclient.methods;

import org.springframework.web.client.RestTemplate;
import test.restclient.model.User;

public class GetByIdExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final Long ID = 232452525245245353L;

    private static final String URL = "http://localhost:8080/rest/" + ID;

    public static void main(String[] args) {
        System.out.println(REST_TEMPLATE.getForObject(URL, User.class));
    }
}
