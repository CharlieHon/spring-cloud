package com.charlie.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Data Getter,Setter,RequiredArgsConstructor,ToString...
 * @NoArgsConstructor 生成无参构造器
 * @AllArgsConstructor 生成全参构造器
 */
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
