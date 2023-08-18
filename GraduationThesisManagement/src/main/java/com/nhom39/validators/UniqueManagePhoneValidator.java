package com.nhom39.validators;

import com.nhom39.pojo.Manage;
import com.nhom39.service.ManageService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueManagePhoneValidator implements Validator {
    private final ManageService manageService;

    public UniqueManagePhoneValidator(ManageService manageService) {
        this.manageService = manageService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Manage manage = (Manage) target;

        if (manage.getId() == null
                && this.manageService.checkUniqueManagePhone(manage.getPhone())) {
            errors.rejectValue("phone", "manage.add.phone.existsMessage",
                    "Số điện thoại quản trị viên đã tồn tại");
        }
    }
}
