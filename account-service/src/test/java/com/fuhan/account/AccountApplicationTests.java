package com.fuhan.account;

import com.fuhan.account.entity.Permissions;
import com.fuhan.account.entity.Role;
import com.fuhan.account.entity.User;
import com.fuhan.account.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class AccountApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(22);
        user.setPassword("5173108646");
        user.setUsername("fuhan");
        user.setEmail("1358724404@qq.com");
        user.setPhone("18702598180");
        List<Role> roles = Collections.singletonList(new Role("admin", Collections.singletonList(new Permissions("add", Collections.singletonList("/add")))));
        user.setTouxiang("/touxiang.jpg");
        user.setCollections(Arrays.asList("545","45646"));
        userService.createUser(user);
    }

}
