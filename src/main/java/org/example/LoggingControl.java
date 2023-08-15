package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingControl {

    private static final Logger logger = LoggerFactory.getLogger(LoggingControl.class);

    public interface LoggingControlMBean {
        void enableLogging();
        void disableLogging();
    }

    public static class MBeanImpl implements LoggingControlMBean {

        private final LoggingAspect aspect;

        public MBeanImpl(LoggingAspect aspect) {
            this.aspect = aspect;
        }

        @Override
        public void enableLogging() {
            aspect.enableLogging();
            logger.info("Logging enabled through MBean.");
        }

        @Override
        public void disableLogging() {
            aspect.disableLogging();
            logger.info("Logging disabled through MBean.");
        }
    }
}