package com.nhom39.controllers.user;

import com.nhom39.pojo.Thesis;
import com.nhom39.pojo.User;
import com.nhom39.service.StudentService;
import com.nhom39.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller(value = "UserHomeController")
public class HomeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ThesisService thesisService;

    @GetMapping(path = "/")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null && user.getStudent() != null) {
            model.addAttribute("student",
                    this.studentService.getStudentById(user.getStudent().getId()));
        }

        return "index";
    }


    @GetMapping(path = "/thesis/{thesisId}")
    public String thesisDetail(Model model, @PathVariable(value = "thesisId") int thesisId) {
        model.addAttribute("thesis", this.thesisService.getThesisById(thesisId));

        Thesis a = this.thesisService.getThesisById(thesisId);
        return "thesisDetail";
    }
}
