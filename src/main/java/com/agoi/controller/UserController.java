package com.agoi.controller;

import com.agoi.pojo.User;
import com.agoi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: agoi
 * @date 2019/09/18 17:49
 */
@Controller
@SessionAttributes({"user"})
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(String uLoginName, String uPassword, ModelMap map) {

        User user = userService.login(uLoginName, uPassword);
        if (user == null) {

            return "login";
        }
        map.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/loginout")
    public String loginout(SessionStatus sessionStatus, HttpServletResponse response) {

        //清除session
        sessionStatus.setComplete();
        return "redirect:/login.jsp";

    }




}