package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    // to avoid constant folding by the compiler, this field must *not* be final
    public static String REQUESTED_API_VERSION = "1.6";  // !final

    private static final String loggerFactoryClassStr = "LoggerShit";

    private final ILoggerFactory loggerFactory;

    private StaticLoggerBinder() {
        loggerFactory = new SimpleLoggerFactory();
    }

    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return loggerFactoryClassStr;
    }
}
