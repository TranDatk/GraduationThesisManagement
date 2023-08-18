/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.controllers.admin;

import org.springframework.ui.Model;
import com.nhom39.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller(value = "AccountController")
@RequestMapping(path = "/admin")
public class AccountController {
      @Autowired
    private UserService userService;

    @GetMapping(path = "/profile")
    public String Profile(Model model, @RequestParam(required = false) Map<String, String> params){
        model.addAttribute("users", this.userService.getUsers(params));
        return "adminAccount";
    }
}

