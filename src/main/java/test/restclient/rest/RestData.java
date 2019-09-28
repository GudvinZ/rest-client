package test.restclient.rest;

import test.restclient.model.User;

import java.util.List;

public interface RestData {
    List<User> findAll();
    User findByLogin(String login);
    User findById(Long id);
    void save(User user);
    void update(User user);
    void deleteById(Long id);
}
