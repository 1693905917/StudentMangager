package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface UserService {
    /*
     * @description:查询user所有信息
     * @author:  HZP
     * @date: 2023/6/27 16:35
     * @param:
     * @return:
     **/
    List<User> list();

    /*
     * @description:存储新用户信息与角色信息
     * @author:  HZP
     * @date: 2023/6/28 8:58
     * @param:
     * @return:
     **/
    //void save(User user, Long[] roleId);
    void save(User user, Long[] roleId);
    /*
     * @description:通过ID删除用户信息
     * @author:  HZP
     * @date: 2023/6/28 9:58
     * @param:
     * @return:
     **/
    void deleteUserById(long userId);

    /*
     * @description:用户登入
     * @author:  HZP
     * @date: 2023/6/28 11:32
     * @param:
     * @return:
     **/
    User login(String username, String password) throws EmptyResultDataAccessException;
}
