package com.nhom39.api.admin;

import com.nhom39.pojo.CouncilDetail;
import com.nhom39.pojo.Department;
import com.nhom39.service.CouncilDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("AdminApiCouncilDetailController")
@RequestMapping("/admin/api")
public class ApiCouncilDetailController {
    @Autowired
    private CouncilDetailService councilDetailService;


    @GetMapping(path = "/councilsDetail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CouncilDetail>> loadDepartment(@RequestParam(required = false) Map<String, String> params) {
        try {
            return new ResponseEntity<>(this.councilDetailService.getCouncilsDetail(params), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
