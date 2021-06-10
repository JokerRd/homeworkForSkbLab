package ru.skblab.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.skblab.aop.configuration.AopConfiguration;
import ru.skblab.aop.exceptions.ExceedingRequestsException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class CounterAspect {

    private final ConcurrentHashMap<String, AtomicInteger> maps;
    private final AopConfiguration configuration;

    public CounterAspect(AopConfiguration configuration) {
        this.maps = new ConcurrentHashMap<>();
        this.configuration = configuration;
    }

    @Around("@annotation(counter)")
    public Object handleRequest(ProceedingJoinPoint pjp, Counter counter) throws Throwable {
        if (!maps.containsKey(counter.id())) {
            maps.put(counter.id(), new AtomicInteger());
        }
        AtomicInteger countRequest = maps.get(counter.id());
        int maxRequest = configuration.getMaxRequest();
        if (counter.maxRequest() != -1) {
            maxRequest = counter.maxRequest();
        }
        if (countRequest.get() > maxRequest) {
            throw new ExceedingRequestsException("The maximum number of requests is exceeded");
        }
        countRequest.incrementAndGet();
        return pjp.proceed();
    }
}
