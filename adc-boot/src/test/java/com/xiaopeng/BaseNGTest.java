package com.xiaopeng;

import com.github.ericmoshare.adc.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by eric.mo on 2017/8/4.
 */
@ActiveProfiles(value = "development")
@SpringBootTest(classes = Application.class)
public abstract class BaseNGTest extends AbstractTestNGSpringContextTests {

    protected static final Logger log = LoggerFactory.getLogger(BaseNGTest.class);
}
