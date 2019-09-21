package com.agoi.controller;

import com.agoi.pojo.Menu;
import com.agoi.pojo.Role;
import com.agoi.service.MenuService;
import com.agoi.service.RoleService;
import com.agoi.utils.InterfaceUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/19 15:55
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    //查询所有的角色,并进行分页
    @RequestMapping("/getroles")
    public String getRoles(String rName, @RequestParam(defaultValue = "1")Integer pageindex, Model model){
        System.out.println(rName);
        PageInfo<Role> pageInfo = roleService.findRoles(pageindex, InterfaceUtil.PAGESIZE,rName);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("rName", rName);
        return "Role/index";
    }


    //进入编辑
    @RequestMapping("/findrolebyid")
    public String findById(Integer rid,Model model){
        //根据角色id查询角色信息
        Role role = roleService.selectByPriMaryKey(rid);
        model.addAttribute("role", role);

        //查询所有菜单的方法
        List<Menu> menus = menuService.findAll();
        model.addAttribute("menuList", menus);
        return "Role/editRole";
    }


    //修改角色权限数据
    @RequestMapping("/updaterole")
    public String updateRole(Role role,int[] group){
        Integer updaterole = roleService.updateRole(group,role);
        if (updaterole>0){
            return "redirect:/getroles";
        }
        return "redirect:/findrolebyid?rid="+role.getrId();
    }



    //删除角色
    @RequestMapping("/deleterole")
    public String deleteRole(Integer rid){
        //根据id删除对应角色信息,service层进行健壮性判断
        Integer count = roleService.deleteRoleById(rid);
        System.out.println(count);
        if (count==1){
            System.out.println("删除成功");
        }
        System.out.println("删除失败");
        return "redirect:/getroles";
    }





}
