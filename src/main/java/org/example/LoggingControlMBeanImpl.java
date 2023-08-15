package org.example;

public class LoggingControlMBeanImpl implements LoggingControl.LoggingControlMBean {
    private final LoggingAspect aspect;

    public LoggingControlMBeanImpl(LoggingAspect aspect) {
        this.aspect = aspect;
    }

    @Override
    public void enableLogging() {
        aspect.enableLogging();
    }

    @Override
    public void disableLogging() {
        aspect.disableLogging();
    }
}