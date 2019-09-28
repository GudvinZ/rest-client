package test.restclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private Long id;

    private String login;

    private String password;

    private String name;

    private Collection<Role> roles;

    public User() {
    }

    public User(Long id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles= Collections.singletonList(new Role());
    }

    public User(String login, String password, String name, Collection<Role> roles) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public User(String login, String password, String name) {
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

    @JsonSetter
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void setRoles(String... roles) {
        this.roles = Stream.of(roles).map(Role::new).collect(Collectors.toList());
    }

    @JsonIgnore
    public List<String> getRolesAsStrings() {
        return roles.stream().map(Role::getRoleName).collect(Collectors.toList());
    }

//    @Override
//    public String toString() {
//        return "id: " + id +
//                "\nlogin: " + login +
//                "\npassword: " + password +
//                "\nname: " + name +
//                "\nroles: " +
//                roles.stream()
//                        .map(x -> "\n\t{\n\t\tid: " + x.getId() + "\n\t\troleName: " + x.getRoleName() + "\n\t}")
//                        .collect(Collectors.joining("\n", "[", "\n]"));
//    }
}
