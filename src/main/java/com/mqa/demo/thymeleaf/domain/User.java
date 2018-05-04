package com.mqa.demo.thymeleaf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mengqa
 * @create 2018-05-04 14:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private String email;

    private Long id;

}
