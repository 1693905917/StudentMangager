package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    /*
     * @description:角色清单
     * @author:  HZP
     * @date: 2023/6/27 14:48
     * @param:
     * @return:
     **/
    List<Role> list();

    void save(Role role);

    void deleteUserById(long roleId);
}
