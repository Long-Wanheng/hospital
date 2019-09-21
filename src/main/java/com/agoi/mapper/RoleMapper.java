package com.agoi.mapper;

import com.agoi.pojo.Role;
import com.agoi.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/19 16:22
 */
public interface RoleMapper {


    List<Role> findRoles(Map map);

    Role selectByPrimaryKey(Integer rId);

    Integer updateByPrimaryKey(Role role);

    Integer deleteMenu(Integer getrId);

    Integer insertMenu(Map map);

//    @Select("select * from user where r_id = #{rid}")
    User selectUserById(Integer rid);

    Integer deleteRoleById(Integer rid);

}
