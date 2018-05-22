package com.ryz.cn.springbootvuemvc.controller;

import com.ryz.cn.springbootvuemvc.pojo.User;
import com.ryz.cn.springbootvuemvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/getUserById",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@RequestParam String id){
        System.out.println("hello user");
        User u = userService.findUserById(id);
        System.out.println(u);
        return u;
    }
    @RequestMapping(value="/foundAll",method = RequestMethod.GET)
    public String getUserById(Model model){
        System.out.println("hello user");
        List<User> users = userService.findAll();
        System.out.println(users);
        model.addAttribute("Users", users );
        return "index";
    }

    @RequestMapping(value="/getUsers",method = RequestMethod.GET)
    @ResponseBody
    public Object getUserById(){
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping(value="/getUserByOneId",method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByOneId(@RequestParam String id){
        User user = userService.findById(id);
        return user;
    }

    @RequestMapping(value="/deleteById",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteById(@RequestParam String id){
        int count = userService.deleteById(id);
        return count;
    }

    @RequestMapping(value="/init",method = RequestMethod.GET)
    @ResponseBody
    public String init(){
        userService.init();
        return "SUCCESS";
    }

    @RequestMapping(value="/findMy",method = RequestMethod.GET)
    @ResponseBody
    public String findMy(String id){

        return userService.findName(id);
    }

    @RequestMapping(value="/addOne",method = RequestMethod.POST)
    @ResponseBody
    public void addOne(@RequestBody User user){

        userService.save(user);
    }
}
