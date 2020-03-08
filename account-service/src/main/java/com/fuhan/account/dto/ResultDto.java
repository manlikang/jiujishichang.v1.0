package com.fuhan.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> implements Serializable {
        private Integer code;
        private T message;
}
