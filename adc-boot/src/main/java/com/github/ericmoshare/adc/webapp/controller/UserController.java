package com.github.ericmoshare.adc.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.enums.MessageCode;
import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.mapper.entity.User;
import com.github.ericmoshare.adc.service.UserService;
import com.github.ericmoshare.adc.webapp.vo.Resp;
import com.github.ericmoshare.adc.webapp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@RequestBody @Valid UserVO request) throws AdcException {
        LOGGER.info("[create]接受请求 = {}", JSON.toJSONString(request));

        User user = new User();

        // copy request对象的所有参数到 user, 如果参数名一致的话
        BeanUtils.copyProperties(request, user);

        Object response = userService.create(user);
        LOGGER.info("[create]响应结果 = {}", response);
        return new ResponseEntity<Resp>(new Resp(MessageCode.success, response), HttpStatus.OK);

    }
}
