package com.github.ericmoshare.adc.webapp.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserLoginVO {

    @org.hibernate.validator.constraints.NotEmpty(message = "userNo必须输入")
    @org.hibernate.validator.constraints.Length(min = 0, max = 30, message = "userNo:长度应在{max}位之内")
    private String userNo;

    @org.hibernate.validator.constraints.NotEmpty(message = "passwd必须输入")
    @org.hibernate.validator.constraints.Length(min = 0, max = 30, message = "passwd:长度应在{max}位之内")
    private String passwd;

}