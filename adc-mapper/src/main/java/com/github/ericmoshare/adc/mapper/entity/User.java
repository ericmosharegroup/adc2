package com.github.ericmoshare.adc.mapper.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private Long id;
    private String userId;
    private String username;
    private String userNo;
    private String passwd;
    private String remark;
    private Date createTime;
    private Date updateTime;


}