package com.nhom39.api.admin;

import com.nhom39.pojo.AcademicAffairs;
import com.nhom39.pojo.Topic;
import com.nhom39.service.AcademicAffairsService;
import com.nhom39.validators.WebAppValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController(value = "AdminApiManageController")
@Validated
@RequestMapping(path = "/admin/api")
public class ApiAcademicAffairsController {

    @Autowired
    private AcademicAffairsService manageService;
    @Autowired
    private WebAppValidator manageValidator;
    @Autowired
    private WebAppValidator userValidator;

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.setValidator(manageValidator);
    }

    @GetMapping(path = "/manages/{manageId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AcademicAffairs> loadManage(@PathVariable(value = "manageId") int manageId) {
        try {
            AcademicAffairs manage = this.manageService.getAcademicAffairsById(manageId);
            return new ResponseEntity<>(manage, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/manages",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> addManage(@RequestPart(value = "avatarFile", required = false) MultipartFile file,
            @RequestPart("manage") @Valid AcademicAffairs manage, BindingResult result) {
        Map<String, String> errorMessages = new HashMap<>();
        HttpStatus status = null;

        if (result.hasErrors()) {
            errorMessages = result.getFieldErrors().stream().collect(Collectors.toMap(
                    new Function<FieldError, String>() {
                @Override
                public String apply(FieldError fieldError) {
                    return fieldError.getField();
                }
            },
                    new Function<FieldError, String>() {
                @Override
                public String apply(FieldError fieldError) {
                    return fieldError.getDefaultMessage();
                }
            }
            ));
            status = HttpStatus.BAD_REQUEST;
        } else {
            if (this.manageService.addAcademicAffairs(manage, file)) {
                status = HttpStatus.CREATED;
            } else {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }

        return new ResponseEntity<>(errorMessages, status);
    }

    @PostMapping(path = "/manages/{manageId}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> updateManage(@PathVariable("manageId") int manageId,
            @RequestPart(value = "avatarFile", required = false) MultipartFile file,
            @Valid @RequestPart("manage") AcademicAffairs manage,
            BindingResult result) {
        Map<String, String> errorMessages = new HashMap<>();
        HttpStatus status = null;

        if (result.hasErrors()) {
            errorMessages = result.getFieldErrors().stream().collect(Collectors.toMap(
                    new Function<FieldError, String>() {
                @Override
                public String apply(FieldError fieldError) {
                    return fieldError.getField();
                }
            },
                    new Function<FieldError, String>() {
                @Override
                public String apply(FieldError fieldError) {
                    return fieldError.getDefaultMessage();
                }
            }
            ));
            status = HttpStatus.BAD_REQUEST;
        } else {
            if (this.manageService.updateAcademicAffairs(manageId, manage, file)) {
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }

        return new ResponseEntity<>(errorMessages, status);
    }

    @DeleteMapping(path = "/manages/{manageId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteManage(@PathVariable("manageId") int manageId) {
        this.manageService.deleteAcademicAffairs(manageId);
    }
}
