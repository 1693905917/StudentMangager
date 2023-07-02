package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-06-27  16:34
 * @Description: TODO
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public List<User> list() {
        List<User> userList = userDao.findAll();
        //对于role与user表建立联系
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roleByUserId = roleDao.findRoleByUserId(id);
            user.setRoles(roleByUserId);
        }
        return userList;
    }

    public void save(User user, Long[] roleId) {
        //第一步向srs_user表中存储数据\获取新存储的用户ID
        Long userId = userDao.save(user);
        //第二步向srs_user_role关系表中存储多条数据
        userDao.saveByUserIdAndRoleId(userId, roleId);

    }

    public void deleteUserById(long userId) {
        //先删关系表
        userDao.deleteUserRoleRelation(userId);
        //再删用户表
        userDao.deleteUserById(userId);
    }

    public User login(String username, String password) throws EmptyResultDataAccessException {
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
