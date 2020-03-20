package com.fwh.blog.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// 该注解拦截所有controller标记的注解
@ControllerAdvice
// 异常拦截器
public class ControllerExceptionHander {
    // 记录异常日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 该注解表示这个方法可以用来做异常处理的
    @ExceptionHandler(Exception.class)
    // 处理异常信息
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        // 获取异常信息的url地址
        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(), e);
        // 判断springboot是否存在错误码,有的话就不用这个方法
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
