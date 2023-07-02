package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.mapper
 * @Author: ASUS
 * @CreateTime: 2023-07-02  09:52
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserMapper {

//    @Select(value = "select * from sys_user")
//    List<User> findAll();
//
//    @Select(value = "select * from sys_user where username=? and password=?")
//    User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException;
//
//    @Insert(value = "insert into sys_user values (?,?,?,?,?)")
//    void save(final User user);
//
//    @Insert(value = "insert into sys_user_role values (?,?)")
//    void saveByUserIdAndRoleId(Long id, Long[] roleId);
//
//    @Delete(value = "delete from sys_user_role where userId=?")
//    void deleteUserRoleRelation(long userId);
//
//    @Delete(value = "delete from sys_user where id=?")
//    void deleteUserById(long userId);


}
