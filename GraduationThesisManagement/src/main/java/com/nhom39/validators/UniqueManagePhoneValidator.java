package com.nhom39.validators;

import com.nhom39.pojo.AcademicAffairs;
import com.nhom39.service.AcademicAffairsService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueManagePhoneValidator implements Validator {
    private final AcademicAffairsService manageService;

    public UniqueManagePhoneValidator(AcademicAffairsService manageService) {
        this.manageService = manageService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AcademicAffairs manage = (AcademicAffairs) target;

        if (manage.getId() == null
                && this.manageService.checkUniqueAcademicAffairsPhone(manage.getPhone())) {
            errors.rejectValue("phone", "manage.add.phone.existsMessage",
                    "Số điện thoại quản trị viên đã tồn tại");
        }
    }
}
