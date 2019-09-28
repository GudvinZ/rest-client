package test.restclient.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.restclient.exception.IsAlreadyExistException;
import test.restclient.exception.NotFoundException;
import test.restclient.model.User;
import test.restclient.rest.RestData;
import test.restclient.rest.RestDataImpl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final RestData restDataImpl;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(RestData restDataImpl, PasswordEncoder passwordEncoder) {
        this.restDataImpl = restDataImpl;
        this.passwordEncoder = passwordEncoder;
    }

    private boolean isValidString(String sParam) {
        return sParam != null && !sParam.isEmpty();
    }

    private boolean checkLogin(String login) {
        try {
            restDataImpl.findByLogin(login);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        if (!isValidString(user.getLogin()) || !isValidString(user.getPassword()) || !isValidString(user.getName()))
            throw new InvalidParameterException();

        if (checkLogin(user.getLogin()))
            throw new IsAlreadyExistException();

        user.setPassword(user.getPassword());

        restDataImpl.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        restDataImpl.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        User old = getUserById(user.getId());

        boolean isValidLogin = isValidString(user.getLogin()) && !old.getLogin().equals(user.getLogin());
        boolean isValidPassword = isValidString(user.getPassword()) && !old.getPassword().equals(user.getPassword());
        boolean isValidName = isValidString(user.getName()) && !old.getName().equals(user.getName());

        if (isValidLogin) {
            if (checkLogin(user.getLogin()))
                throw new IsAlreadyExistException();
            old.setLogin(user.getLogin());
        }
        if (isValidPassword)
            old.setPassword(user.getPassword());
        if (isValidName)
            old.setName(user.getName());
        restDataImpl.update(old);
    }

    public List<User> getAllUsers() {
        return restDataImpl.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return restDataImpl.findById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return restDataImpl.findByLogin(login);
    }

    public UserDetails loadUserByUsername(String login) {
        User user = getUserByLogin(login);

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList()));
    }
}
