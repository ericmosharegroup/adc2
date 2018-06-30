package com.github.ericmoshare.adc.service.impl;

import com.github.ericmoshare.adc.enums.MessageCode;
import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.mapper.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;

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
            LOGGER.error("用户已存在,无需注册. user = {}" + user);
            throw new AdcException(MessageCode.duplicateUser, "用户已存在,无需注册");
        }
    }
}
