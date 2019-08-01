package ru.sb.meetroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserDto userDto) {
        if (userDto == null) {
            return new ResponseEntity<>("{\"error\":\"" + "userDto is null" + "\"}", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createUser(userDto));
    }
}
