package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public  User saveUser(@RequestBody User user)
    {
        log.info("Inside user controller save method");
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVo getUserDepartment(@PathVariable("userId") Long userId)
    {
        log.info("Getting information for usercum department from UserController");
        return userService.getUserByDepartment(userId);
    }
}
