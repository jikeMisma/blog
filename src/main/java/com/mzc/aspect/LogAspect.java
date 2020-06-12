package com.mzc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mazhicheng
 * @date 2020/5/1 - 12:47
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.mzc.web.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMetgod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMetgod,args);

        logger.info("Request: {}",requestLog);
    }

    @After("log()")
    public void doAfter(){
//        logger.info("-------------doAfter------------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public  void doAfterReturn(Object result){
        logger.info("result : {}",result);
    }

    private  class RequestLog{
        private  String url;
        private  String ip;
        private  String classMetgod;
        private Object args;

        public RequestLog(String url, String ip, String classMetgod, Object args) {
            this.url = url;
            this.ip = ip;
            this.classMetgod = classMetgod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMetgod='" + classMetgod + '\'' +
                    ", args=" + args +
                    '}';
        }
    }
}
