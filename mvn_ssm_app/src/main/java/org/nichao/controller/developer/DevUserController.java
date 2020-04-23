package org.nichao.controller.developer;

import org.nichao.dao.DataDictionaryDao;
import org.nichao.pojo.AppCategory;
import org.nichao.pojo.DataDictionary;
import org.nichao.pojo.DevUser;
import org.nichao.service.developer.AppCategoryService;
import org.nichao.service.developer.DataDictionaryService;
import org.nichao.service.developer.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class DevUserController {
    @Resource
    private DevUserService devUserService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
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
    @RequestMapping("appinfolist")
    public String appinfolist(ModelMap modelMap){
        List<DataDictionary> apppintai= dataDictionaryService.apppintai();
        List<DataDictionary> appzhuangtai=dataDictionaryService.appzhuangtai();
        List<AppCategory> appCategories=appCategoryService.firstGrade();
        modelMap.addAttribute("apppintai",apppintai);
        modelMap.addAttribute("appzhuangtai",appzhuangtai);
        modelMap.addAttribute("appCategories",appCategories);
        return "jsp/developer/appinfolist";
    }
    @RequestMapping("categoryGradelist")
    @ResponseBody
    public List<AppCategory> categorylevellist(String pid){
        List<AppCategory> secondList=appCategoryService.secondGrade(Integer.parseInt(pid));
        return secondList;
    }
}
