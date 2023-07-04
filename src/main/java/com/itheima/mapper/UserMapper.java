package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
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

    @Select(value = "select * from sys_user")
    List<User> findAll();

    @Select(value = "select * from sys_user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password) throws EmptyResultDataAccessException;

    @Insert(value = "insert into sys_user values (#{id},#{username},#{email},#{password},#{phoneNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(User user);

    @Insert(value = "insert into sys_user_role values (#{userId},#{roleId})")
    void saveByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Delete(value = "delete from sys_user_role where userId=#{userId}")
    void deleteUserRoleRelation(@Param("userId") long userId);

    @Delete(value = "delete from sys_user where id=#{userId}")
    void deleteUserById(@Param("userId") long userId);


}
