package test.restclient.model;

import com.sun.javafx.binding.StringFormatter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;

    private String login;

    private String password;

    private String name;

    private Collection<Role> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles= Collections.singletonList(new Role());
    }

    public UserDTO(String login, String password, String name, Collection<Role> roles) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public UserDTO(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nlogin: " + login +
                "\npassword: " + password +
                "\nname: " + name +
                "\nroles: " +
                roles.stream()
                        .map(x -> "\n\t{\n\t\tid: " + x.getId() + "\n\t\troleName: " + x.getRoleName() + "\n\t}")
                        .collect(Collectors.joining("\n", "[", "\n]"));
    }
}
