package com.nhom39.validators;

import com.nhom39.pojo.Major;
import com.nhom39.service.MajorService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueMajorCodeValidator implements Validator {
    private final MajorService majorService;

    public UniqueMajorCodeValidator(MajorService majorService){
        this.majorService = majorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Major.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Major major = (Major) target;

        if(major.getId() == null &&
                this.majorService.checkUniqueMajorCode(major.getCode())){
            errors.rejectValue("code", "major.add.code.existsMessage",
                    "Mã ngành đã tồn tại");
        }
    }
}
