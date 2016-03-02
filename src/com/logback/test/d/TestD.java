package com.logback.test.d;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by niu_ben on 2015/10/27.
 */
public class TestD {
    private static Logger log = LoggerFactory.getLogger(TestD.class);

    public TestD() {
        log.debug("TestD-debug");
        log.info("TestD-info");
        log.warn("TestD-warn");
        log.error("TestD-error");
    }
}
