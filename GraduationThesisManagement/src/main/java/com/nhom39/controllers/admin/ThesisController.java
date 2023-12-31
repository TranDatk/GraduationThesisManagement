package com.nhom39.controllers.admin;

import com.nhom39.pojo.User;
import com.nhom39.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@Controller(value = "AdminThesisController")
@RequestMapping(path = "/admin")
public class ThesisController {
    @Autowired
    private ThesisService thesisService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private SchoolYearService schoolYearService;
    @Autowired
    private TopicService topicService;

    private void getOptions(Model model, @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("topicOptions", this.topicService.getTopicOptions());
        model.addAttribute("majorOptions", this.majorService.getMajorOptions());
        model.addAttribute("schoolYearOptions", this.schoolYearService.getSchoolYearOptions());

        model.addAttribute("page", Integer.parseInt((params.get("page") != null && !params.get("page").isEmpty()) ? params.get("page") : "1"));
        model.addAttribute("totalPage", this.thesisService.countThesis(params));
        model.addAttribute("theses", this.thesisService.getTheses(params));
    }

    @GetMapping(path = "/theses")
    public String getThesisList(Model model, @RequestParam(required = false) Map<String, String> params) {
        this.getOptions(model, params);

        return "adminThesisList";
    }

    @GetMapping(path = "/theses-guide")
    public String getThesisGuideList(Model model, @RequestParam(required = false) Map<String,
            String> params, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser.getLecturer() != null) {
            params.put("lecturerGuideId", Objects.toString(currentUser.getLecturer().getId()));
        }
        this.getOptions(model, params);

        return "adminThesisGuideList";
    }

    @GetMapping(path = "/theses-review")
    public String getThesisReviewList(Model model,
                                      @RequestParam(required = false) Map<String, String> params,
                                      HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser.getLecturer() != null) {
            params.put("lecturerReviewId", Objects.toString(currentUser.getLecturer().getId()));
        }

        this.getOptions(model, params);

        return "adminThesisReviewList";
    }
}
