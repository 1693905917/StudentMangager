package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleDao {
    /*
     * @description:查询所有角色信息
     * @author:  HZP
     * @date: 2023/6/27 14:42
     * @param:
     * @return:
     **/
    List<Role> findAll();

    /*
     * @description:添加角色
     * @author:  HZP
     * @date: 2023/6/27 15:24
     * @param:
     * @return:
     **/
    void save(Role role);

    /*
     * @description:通过userID与role表建立联系
     * @author:  HZP
     * @date: 2023/6/27 16:26
     * @param:
     * @return:
     **/
    List<Role> findRoleByUserId(Long id);

}
