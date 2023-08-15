package com.nhom39.controllers.admin;

import com.nhom39.service.DepartmentService;
import com.nhom39.service.LecturerService;
import com.nhom39.service.PositionService;
import com.nhom39.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller(value = "AdminLecturerController")
@RequestMapping(path = "/admin")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/lecturers")
    public String lecturerList(Model model, @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("positionOptions", this.positionService.getPositionOptions());
        model.addAttribute("departmentOptions", this.departmentService.getDepartmentOptions());
        model.addAttribute("roleOptions", this.roleService.getRoleOptions(new String[]{"ADMIN", "STUDENT"}));

        model.addAttribute("page", Integer.parseInt((params.get("page") != null && !params.get("page").isEmpty())
                ? params.get("page") : "1"));
        model.addAttribute("totalPage", this.lecturerService.countLecturer(params));
        model.addAttribute("lecturers", this.lecturerService.getLecturers(params));

        return "adminLecturerList";
    }

}
