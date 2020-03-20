package com.fwh.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

// 该注解为标记该类为使用切面进行日志处理
@Aspect
// 开启组件扫描
@Component
public class LogAspect {
    // 输出一个字符串记录
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //该注解声明为切面,execution规定拦截哪一些类(web下所有的类)
    @Pointcut("execution(* com.fwh.blog.web.*.*(..))")
    public void log() {
    }

    // 该注解表示该方法是切面之前所实行的方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        // 获取HTTP的request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取request对象的请求url和访问者ip
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();

        // 通过切面获取调用方法classMethod和请求参数args
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 把日志记录的信息封装到返回内容requestLog里
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    // 该注解表示该方法是切面之后所实行的方法
    @After("log()")
    public void doAfter() {
      //  logger.info("--------doAfter--------");
    }

    // 该注解表示切面运行后获取返回的结果
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result) {
        // 捕获返回内容
        logger.info("Result : {}", result);
    }
}
