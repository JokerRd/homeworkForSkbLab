package ru.skblab.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.skblab.aop.configuration.AopConfiguration;
import ru.skblab.aop.exceptions.ExceedingRequestsException;

@Aspect
@Component
public class CounterAspect {

    private int countRequest;

    private final AopConfiguration configuration;

    public CounterAspect(AopConfiguration configuration) {
        this.configuration = configuration;
    }

    @Around("@annotation(Counter)")
    public Object handleRequest(ProceedingJoinPoint pjp) throws Throwable {
        if (countRequest > configuration.getMaxRequest()) {
            throw new ExceedingRequestsException("The maximum number of requests is exceeded");
        }
        countRequest++;
        return pjp.proceed();
    }
}
