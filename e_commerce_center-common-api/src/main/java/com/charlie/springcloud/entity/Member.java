package com.charlie.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    private Long id;
    private String name;
    private String pwd;
    private String mobile;
    private String email;
    private Integer gender;
}
