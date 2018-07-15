package com.xiaopeng.mapper.mapper;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.mapper.entity.UserExample;
import com.github.ericmoshare.adc.mapper.repository.UserRepository;
import com.xiaopeng.mapper.BaseNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.awt.image.ByteLookupTable;
import java.util.List;
import java.util.Random;

/**
 * @author eric.mo
 * @since 2018/5/4
 */
public class UsrerRepositoryTest extends BaseNGTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void selectCountByTable() {

        int result = userRepository.countByExample(new UserExample());

        System.out.println(result);

    }

    @Test
    public void selectByTable() {

        List<User> result = userRepository.selectByExample(new UserExample());

        System.out.println(JSON.toJSONString(result, true));

        System.out.println(result);
    }


    @Test
    public void delete() {

        int result = userRepository.deleteByPrimaryKey(3L);

        System.out.println(result);

    }


    @Test
    public void insert() {
        int t = new Random().nextInt(2);
        User user = new User();
        user.setUsername("123" + t);
        user.setUserNo("52@qq.com" + t);
        user.setPasswd("12345678");


        int result = userRepository.insertSelective(user);

        System.out.println(result);

    }

    @Test
    public void insert2() {

        for (int i = 0; i < 10; i++) {
            insert();
        }

    }
}
