package com.github.ericmoshare.adc.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.enums.MessageCode;
import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.mapper.entity.UserExample;
import com.github.ericmoshare.adc.mapper.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.github.ericmoshare.adc.enums.MessageCode.userNotExist;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
@Service
public class UserServiceImpl implements com.github.ericmoshare.adc.service.UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public int create(User user) throws IllegalArgumentException, AdcException {
        user.setCreateTime(new Date());

        try {
            return userRepository.insertSelective(user);
        } catch (DuplicateKeyException e) {
            LOGGER.error("用户已存在,无需注册. user = {}", JSON.toJSONString(user));
            throw new AdcException(MessageCode.duplicateUser, "用户已存在,无需注册");
        }
    }

    @Override
    public boolean login(String userNo, String passwd) throws AdcException {
        UserExample example = new UserExample();
        example.createCriteria().andUserNoEqualTo(userNo);

        List<User> users = userRepository.selectByExample(example);

        if (users == null || users.size() < 1) {
            //查无此人
            throw new AdcException(MessageCode.userNotExist);
        }

        User user = users.get(0);

        if (!user.getPasswd().equals(passwd)) {
            //密码不正确
            throw new AdcException(MessageCode.passwdError);
        }

        //密码正确
        return true;
    }

    @Override
    public int delete(Long Id) throws AdcException {

        try {

            return userRepository.deleteByPrimaryKey(Id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


}
