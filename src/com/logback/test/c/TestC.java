package com.logback.test.c;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by niu_ben on 2015/10/27.
 */
public class TestC {
    private static Logger log = LoggerFactory.getLogger(TestC.class);

    public TestC() {
        log.debug("TestC-debug");
        log.info("TestC-info");
        log.warn("TestC-warn");
        log.error("TestC-error");
    }
}
