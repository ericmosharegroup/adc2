package com.github.ericmoshare.adc.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
@RestController
public class HealthCheckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckController.class);

    @RequestMapping(value = "/healthcheck", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> healthCheck() {
        LOGGER.info("healthcheck: {}", HttpStatus.OK.getReasonPhrase().toLowerCase());
        return new ResponseEntity<String>(HttpStatus.OK.getReasonPhrase().toLowerCase(), HttpStatus.OK);
    }
}
