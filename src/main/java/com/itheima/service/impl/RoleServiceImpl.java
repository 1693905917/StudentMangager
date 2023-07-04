package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-06-27  14:48
 * @Description: TODO
 * @Version: 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    //private RoleDao roleDao;
    @Autowired
    private RoleMapper roleMapper;

    //public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }

    public List<Role> list() {
        List<Role> roleDaoAll = roleMapper.findAll();
        return roleDaoAll;
    }

    public void save(Role role) {
        roleMapper.save(role);
    }
}
