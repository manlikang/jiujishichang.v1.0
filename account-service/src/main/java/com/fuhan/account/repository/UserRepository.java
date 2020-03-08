package com.fuhan.account.repository;

import com.fuhan.account.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByUsername(String name);

    User findByPhone(String phone);
}
