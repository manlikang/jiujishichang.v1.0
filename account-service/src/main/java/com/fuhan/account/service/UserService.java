package com.fuhan.account.service;

import com.fuhan.account.dto.ResultDto;
import com.fuhan.account.entity.User;

public interface UserService {
    ResultDto<String> createUser(User user);

    User findByName(String name);

    User findByPhone(String phone);
}
