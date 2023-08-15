package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private boolean loggingEnabled = true;
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    public void enableLogging() {
        loggingEnabled = true;
        logger.info("Logging enabled.");
    }

    public void disableLogging() {
        loggingEnabled = false;
        logger.info("Logging disabled.");
    }

    @Before("execution(* org.example.StringTransformer.transform(String)) && loggingEnabled")
    public void logOriginalInput(JoinPoint joinPoint) {
        logger.info("Original input: " + joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "execution(* org.example.StringTransformer.transform(String)) && loggingEnabled", returning = "result")
    public void logTransformedResult(String result) {
        logger.info("Transformed result: " + result);
    }
}