package com.itheima.mapper;

import com.itheima.domain.Role;
import javafx.scene.chart.ValueAxis;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.mapper
 * @Author: ASUS
 * @CreateTime: 2023-07-02  09:53
 * @Description: TODO
 * @Version: 1.0
 */
public interface RoleMapper {
    @Select(value = "select * from sys_role")
    public List<Role> findAll();

    @Insert(value = "insert into sys_role values (#{id},#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select(value = "select * from sys_user_role,sys_role where sys_user_role.roleId=sys_role.id and sys_user_role.userId=#{id}")
    public List<Role> findRoleByUserId(@Param("id") Long id);


    @Delete(value = "delete from sys_user_role where roleId=#{roleId}")
    void deleteUserRoleRelation(@Param("roleId") long roleId);

    @Delete(value = "delete from sys_role where id=#{id}")
    void deleteRoleById(@Param("id") long id);
}
