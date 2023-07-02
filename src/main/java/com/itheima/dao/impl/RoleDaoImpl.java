package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.dao.impl
 * @Author: ASUS
 * @CreateTime: 2023-06-27  14:40
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());

    }

    public List<Role> findRoleByUserId(Long id) {
        List<Role> roleList = jdbcTemplate.query("select * from sys_user_role,sys_role where sys_user_role.roleId=sys_role.id and sys_user_role.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }


}
