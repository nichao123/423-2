package org.nichao.controller.developer;

import org.nichao.pojo.DevUser;
import org.nichao.service.developer.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class DevUserController {
    @Resource
    private DevUserService devUserService;
    @RequestMapping("/login")
    public  String login(ModelMap modelMap,String devCode,String devPassword){
        DevUser devUser=devUserService.findByCode(devCode);
        if (devUser.getDevPassword().equals(devPassword)) {
            modelMap.addAttribute("devUser", devUser);
            return "/jsp/developer/main";
        }else {
            return "/jsp/devlogin";
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("devUser");
        return "jsp/index";
    }
}
