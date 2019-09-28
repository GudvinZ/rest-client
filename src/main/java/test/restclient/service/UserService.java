package test.restclient.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import test.restclient.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long param);

    User getUserByLogin(String param);
}
