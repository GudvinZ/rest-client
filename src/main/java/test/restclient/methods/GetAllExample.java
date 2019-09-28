package test.restclient.methods;

import org.springframework.web.client.RestTemplate;
import test.restclient.model.User;

import java.util.List;

public class GetAllExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final String URL = "http://localhost:8080/rest";

    private static class userList {
        private List<User> list;

        public userList(List<User> list) {
            this.list = list;
        }
    }

    public static void main(String[] args) {
//        ResponseEntity<?> response = REST_TEMPLATE.exchange(
//                URL,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<UserDTO>>() {
//                });
//
//        System.out.println(response.getBody());

        System.out.println(REST_TEMPLATE.getForObject(URL, userList.class));
    }
}
