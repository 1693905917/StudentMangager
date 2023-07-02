package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface UserDao {
    /*
     * @description:查询所有user信息
     * @author:  HZP
     * @date: 2023/6/27 16:31
     * @param:
     * @return:
     **/
    List<User> findAll();

    /*
     * @description:存储用户信息并且返回新用户ID
     * @author:  HZP
     * @date: 2023/6/28 9:35
     * @param:
     * @return:
     **/
    Long save(User user);

    /*
     * @description:存储用户与角色ID关系信息
     * @author:  HZP
     * @date: 2023/6/28 9:06
     * @param:
     * @return:
     **/
    void saveByUserIdAndRoleId(Long id, Long[] roleId);

    void deleteUserRoleRelation(long userId);

    void deleteUserById(long userId);

    User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException;
}
