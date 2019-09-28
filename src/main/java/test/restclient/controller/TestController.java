package test.restclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.restclient.model.User;
import test.restclient.rest.RestData;
import test.restclient.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
    private final RestData restData;
    private final UserService userService;

    public TestController(RestData restData, UserService userService) {
        this.restData = restData;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(restData.findByLogin("1"));
//        restData.save(new User("90", "90", "90"));
//        return ResponseEntity.ok().build();
    }
}
