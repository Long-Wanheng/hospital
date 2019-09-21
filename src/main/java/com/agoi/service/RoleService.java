package com.agoi.service;

import com.agoi.pojo.Role;
import com.github.pagehelper.PageInfo;

/**
 * @author: agoi
 * @date 2019/09/19 15:58
 */
public interface RoleService {
    PageInfo<Role> findRoles(Integer pageindex, Integer pagesize, String rName);

    Role selectByPriMaryKey(Integer rId);

    Integer updateRole(int[] group, Role role);

    Integer deleteRoleById(Integer rid);
}
