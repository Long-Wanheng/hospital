package com.agoi.service.impl;

import com.agoi.mapper.RoleMapper;
import com.agoi.pojo.Role;
import com.agoi.pojo.User;
import com.agoi.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/19 15:59
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> findRoles(Integer pageindex, Integer pagesize, String rName) {

        PageHelper.startPage(pageindex, pagesize);
        Map map = new HashMap();
        map.put("rName", rName);
        List<Role> roles = roleMapper.findRoles(map);
        System.out.println(roles);
        return new PageInfo(roles);
    }

    @Override
    public Role selectByPriMaryKey(Integer rId) {
        return roleMapper.selectByPrimaryKey(rId);
    }



    @Override
    @Transactional
    public Integer updateRole(int[] group, Role role) {
        int q = 0;
        //1.修改角色表
        Integer count = roleMapper.updateByPrimaryKey(role);
        System.out.println(count);
        //2.修改权限(删除原有的权限,新增新的权限)
        Integer del = roleMapper.deleteMenu(role.getrId());
        System.out.println(del);
        Map map = new HashMap();
        map.put("roleid", role.getrId());
        map.put("group", group);
        System.out.println(map);
        Integer integer = roleMapper.insertMenu(map);
        q=1;
        return q;
    }


    @Override
    @Transactional
    public Integer deleteRoleById(Integer rid) {

        int q = 0;
        //根据id到user表中查询该角色类型下是否有用户
/*        Map map = new HashMap();
        map.put("rid", rid);*/
        User user = roleMapper.selectUserById(rid);
        if (user==null){
            //删除权限role_menu表中的权限
            Integer del = roleMapper.deleteMenu(rid);
            //删除角色表role的数据
            Integer count = roleMapper.deleteRoleById(rid);
            System.out.println(del+"~"+count);
            q=1;
        }

        return q;
    }
}
