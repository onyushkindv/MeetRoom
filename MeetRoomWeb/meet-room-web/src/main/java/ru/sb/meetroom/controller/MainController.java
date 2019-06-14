package ru.sb.meetroom.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sb.meetroom.dto.UserDto;
import ru.sb.meetroom.model.User;
import ru.sb.meetroom.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MainController {

    ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public MainController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @RequestMapping(value = "/getName", method = {RequestMethod.GET})
    public UserDto getName(@RequestParam(value = "name", required = false) String name){
        User user = userService.getByName(name);
        return modelMapper.map(user, UserDto.class);
    }

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List<UserDto> getName(){
        List<User> users = userService.getAll(0,100);
        return modelMapper.map(users, new TypeToken<List<UserDto>>(){}.getType());
    }

}
