package iducs.springboot.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectConfig {
    Logger logger =  LoggerFactory.getLogger(LogAspectConfig.class);
    @Pointcut("execution(* iducs.springboot.blog.config.*Config.*(..))")
    public void loggingPointcut() { }

    @Around("loggingPointcut()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("confstart - " + pjp.getSignature().getDeclaringTypeName());
        Object result = pjp.proceed();
        logger.info("confend - " + pjp.getSignature().getName());
        return result;
    }
}