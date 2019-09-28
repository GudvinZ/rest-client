package test.restclient.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import test.restclient.config.RestTemplateResponseErrorHandler;
import test.restclient.model.User;

import java.util.List;

@Component
public class RestDataImpl implements RestData {
    private final RestTemplate restTemplate;

    private static final String URL = "http://localhost:8081/rest";

    public RestDataImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

//    private static class UserList {
//        private List<User> list;
//
//        public List<User> getList() {
//            return list;
//        }
//
//        public void setList(List<User> list) {
//            this.list = list;
//        }
//
//        public UserList(List<User> list) {
//            this.list = list;
//        }
//    }

    @Override
    public User findByLogin(String login) {
        String url = URL + "/login=" + login;
        return restTemplate.getForObject(url, User.class);
    }

    @Override
    public void save(User user) {
        restTemplate.postForLocation(URL, user);
    }

    @Override
    public void deleteById(Long id) {
        String url = URL + "/" + id;
        restTemplate.delete(url);
    }

    @Override
    public void update(User user) {
        restTemplate.put(URL, user);
    }

    @Override
    public List<User> findAll() {
//        return restTemplate.getForObject(URL, UserList.class).getList();
        return restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }

    @Override
    public User findById(Long id) {
        String url = URL + "/id=" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
