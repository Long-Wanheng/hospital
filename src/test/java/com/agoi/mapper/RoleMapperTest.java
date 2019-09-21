package com.agoi.mapper;

import com.agoi.pojo.Role;
import com.agoi.pojo.User;
import com.ssmTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/19 16:28
 */
public class RoleMapperTest extends ssmTest {

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void findRoles() {
        Map map = new HashMap();
        map.put("rName", null);
        List<Role> roles = roleMapper.findRoles(map);
        System.out.println(roles.get(1));

    }

    @Test
    public void selectUserById() {
/*        Map map = new HashMap();
        map.put("rid", 1);*/
        User user = roleMapper.selectUserById(1);
        System.out.println(user);
        System.out.println(user.getuLoginName());
    }
}