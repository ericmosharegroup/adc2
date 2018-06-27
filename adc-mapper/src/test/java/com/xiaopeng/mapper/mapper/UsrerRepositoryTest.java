package com.xiaopeng.mapper.mapper;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.mapper.entity.UserExample;
import com.github.ericmoshare.adc.mapper.repository.UserRepository;
import com.xiaopeng.mapper.BaseNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

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
    }

}
