package com.itheima.resolver;

import com.itheima.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.resolver
 * @Author: ASUS
 * @CreateTime: 2023-06-28  14:38
 * @Description: TODO
 * @Version: 1.0
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");
        } else {
            modelAndView.addObject("info", "类型转换异常");
        }
        modelAndView.setViewName("error/failer");
        return modelAndView;
    }
}
