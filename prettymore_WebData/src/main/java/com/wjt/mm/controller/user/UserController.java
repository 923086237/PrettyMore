package com.wjt.mm.controller.user;

import com.wjt.mm.com.vo.R;
import com.wjt.mm.pojo.user.User;
import com.wjt.mm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Barrior丶
 * @date 2018/10/24 22:21
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userigister.do")
    public R save(User user){
        return userService.register(user);
    }
}
