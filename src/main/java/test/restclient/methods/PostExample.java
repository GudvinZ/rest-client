package test.restclient.methods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import test.restclient.model.Role;
import test.restclient.model.User;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final String LOGIN = "test6";
    private static final String PASSWORD = "test";
    private static final String NAME = "test";
    private static final String[] ROLES = {"user"};

    private static final String URL = "http://localhost:8080/rest";

    public static void main(String[] args) {
        User user = new User(LOGIN, PASSWORD, NAME, Stream.of(ROLES).map(Role::new).collect(Collectors.toList()));

        try {
            ResponseEntity<User> responseEntity = REST_TEMPLATE.postForEntity(URL, user, User.class);
            System.out.println(responseEntity.getStatusCode());
            System.out.println(responseEntity.getHeaders().get("Location"));
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
