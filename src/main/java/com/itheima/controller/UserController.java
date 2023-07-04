package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-06-27  16:42
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView UserList(ModelAndView modelAndView) {
        List<User> userList = userService.list();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView RoleList(ModelAndView modelAndView) {
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleId) {
        //for (Long aLong : roleId) {
        //userService.save(user, aLong);
//            System.out.println("&&&&&&"+aLong);
        //}
        userService.save(user, roleId);

        System.out.println("存储用户信息与角色信息成功......");
        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUserById(@PathVariable("userId") long userId) {
        userService.deleteUserById(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String loin(String username, String password, HttpSession session) throws EmptyResultDataAccessException {
        User user = userService.login(username, password);
        if (user != null) {
            //登录成功将user存储到session
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }


}
