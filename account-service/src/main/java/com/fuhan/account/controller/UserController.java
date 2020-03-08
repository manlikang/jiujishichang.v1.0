package com.fuhan.account.controller;

import com.fuhan.account.dto.ResultCode;
import com.fuhan.account.dto.ResultDto;
import com.fuhan.account.entity.User;
import com.fuhan.account.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResultDto<String> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("doLogin")
    public ResultDto<String> doLogin(@RequestParam String phone, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            return new ResultDto<>(ResultCode.PASSWORDERROR,"密码错误");
        } catch (UnknownAccountException uae) {
            return new ResultDto<>(ResultCode.ACCOUNTNOTEXIST,"用户不存在");
        }

        User user = userService.findByPhone(phone);
        subject.getSession().setAttribute("user", user);
        return new ResultDto<>(ResultCode.SUCCESS,"登录成功");
    }
}
