package com.xiaopeng;


import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;


public class UserServiceTest extends BaseNGTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws AdcException {

        User user = new User();
        user.setUsername("123");
        user.setUserNo("52@qq.com");
        user.setPasswd("12345678");

        userService.create(user);
    }

    @Test
    public void testLogin() throws AdcException {

        User user = new User();
        user.setUserNo("52@qq.com");
        user.setPasswd("12345678");

        boolean result = userService.login(user.getUserNo(), user.getPasswd());
        System.out.println(">>>>" + result);
    }

    @Test
    public void testDelete() throws AdcException {

        userService.delete(4L);


    }
}
