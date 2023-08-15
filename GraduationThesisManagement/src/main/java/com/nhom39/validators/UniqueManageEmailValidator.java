package com.nhom39.validators;

import com.nhom39.pojo.AcademicAffairs;
import com.nhom39.service.AcademicAffairsService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueManageEmailValidator implements Validator {
    private final AcademicAffairsService academicAffairsService;

    public UniqueManageEmailValidator(AcademicAffairsService manageService){
        this.academicAffairsService = manageService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AcademicAffairs academicAffairs = (AcademicAffairs) target;

        if(academicAffairs.getId() == null
                && this.academicAffairsService.checkUniqueAcademicAffairsEmail(academicAffairs.getEmail())){
            errors.rejectValue("email", "manage.add.email.existsMessage",
                    "Email quản trị viên đã tồn tại");
        }
    }
}
