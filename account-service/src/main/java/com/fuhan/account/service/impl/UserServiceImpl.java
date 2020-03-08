package com.fuhan.account.service.impl;

import com.fuhan.account.config.PasswordHelper;
import com.fuhan.account.dto.ResultCode;
import com.fuhan.account.dto.ResultDto;
import com.fuhan.account.entity.User;
import com.fuhan.account.repository.UserRepository;
import com.fuhan.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public ResultDto<String> createUser(User user) {
        String username = user.getUsername();
        String phone = user.getPhone();
        User user1 = repository.findByPhone(phone);
        User user2 = repository.findByUsername(username);
        if(user1 != null){
            return new ResultDto<>(ResultCode.PHONEISEXIST,"该手机号已存在");
        }
        if(user2 != null){
            return new ResultDto<>(ResultCode.USERISEXIST,"该用户名已存在");
        }
        new PasswordHelper().encryptPassword(user);
        repository.save(user);
        return new ResultDto<>(ResultCode.SUCCESS,"注册成功");
    }

    @Override
    public User findByName(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public User findByPhone(String phone) {
        return repository.findByPhone(phone);
    }


}
