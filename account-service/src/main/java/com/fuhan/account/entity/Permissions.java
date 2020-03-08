package com.fuhan.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "permission")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions implements Serializable {
    @Id
    private String permission;
    private List<String> urls;
}
