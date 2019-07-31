package ru.sb.meetroom.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.mapper.UserMapper;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class MainController {

    private UserService userService;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public MainController( UserService userService) {
        this.userService = userService;
    }


    @Secured(value = {"ROLE_ADMIN"})
    @GetMapping(value = "/getName")
    public UserDto getName(@RequestParam(value = "name", required = false) String name) {
        User user = userService.getByName(name);
        return mapper.destinationToSource(user);
    }


    @RequestMapping("/token")
    public String token(HttpSession session) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode("123");
    }

    @RequestMapping("/login")
    public String login() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode("123");
    }

    @RequestMapping("/fail")
    public String fail() {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return "fail";
    }
}
