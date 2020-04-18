package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SimpleLoggerFactory implements ILoggerFactory {

    final static SimpleLoggerFactory INSTANCE = new SimpleLoggerFactory();

    Map loggerMap;

    public SimpleLoggerFactory() {
        loggerMap = new HashMap();
    }
    public Logger getLogger(String name) {
        Logger slogger = null;

        synchronized (this) {
            slogger = (Logger) loggerMap.get(name);
            if (slogger == null) {
                slogger = new SimpleLogger(name);
                loggerMap.put(name, slogger);
            }
        }
        return slogger;
    }
}
