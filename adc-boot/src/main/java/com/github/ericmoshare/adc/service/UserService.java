package com.github.ericmoshare.adc.service;

import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
public interface UserService {

    int create(User user) throws IllegalArgumentException, AdcException;

    boolean login(String userNo, String passwd) throws AdcException;

    int delete(Long Id) throws AdcException;
}
