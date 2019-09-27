package test.restclient.methods;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import test.restclient.model.UserDTO;

import java.util.List;

public class GetAllExample {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final String URL = "http://localhost:8080/rest";

    private static class userList {
        private List<UserDTO> list;

        public userList(List<UserDTO> list) {
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
