package com.xiaopeng.test;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.service.UserService;
import com.xiaopeng.BaseNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author eric.mo
 * @since 2018/5/4
 */
public class UsrerServiceTest extends BaseNGTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() throws AdcException {

        User user = new User();
        user.setUserNo(System.currentTimeMillis() + "");
        user.setPasswd("12345678");
        user.setUsername(System.currentTimeMillis() + "");

        int result = userService.create(user);
        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void login() throws AdcException {

        User user = new User();
        user.setUserNo("1531878038131");
        user.setPasswd("12345678");

        Object result = userService.login(user.getUserNo(), user.getPasswd());
        System.out.println(JSON.toJSONString(result, true));
    }
}
