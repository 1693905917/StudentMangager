package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.interceptor
 * @Author: ASUS
 * @CreateTime: 2023-06-28  11:12
 * @Description: 拦截器  对于用户是否登入进行拦截
 * @Version: 1.0
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录  本质：判断session中没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            //没有登录
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //放行  访问目标资源
        return true;
    }
}
