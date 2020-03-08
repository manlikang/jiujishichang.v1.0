package com.fuhan.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    @Id
    private String username;
    private String email;
    private String password;
    private String phone;
    private Date singUpDate = new Date();
    private boolean enabled=false;
    private String touxiang;
    private Integer age;
    private List<Role> roles ;
    private List<String> collections;
    private String salt;

    public String getCredentialsSalt() {
        return phone + salt + salt;
    }

}
