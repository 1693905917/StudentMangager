package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-06-27  14:54
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    /*
     * @description:角色列表展示
     * @author:  HZP
     * @date: 2023/6/27 16:03
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     **/
    public ModelAndView list(ModelAndView modelAndView) {
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        //System.out.println(roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/delete/{roleId}")
    public String deleteUserById(@PathVariable("roleId") long roleId) {
        roleService.deleteUserById(roleId);
        return "redirect:/role/list";
    }


}
