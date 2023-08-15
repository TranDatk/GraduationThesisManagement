package com.nhom39.validators;

import com.nhom39.pojo.Lecturer;
import com.nhom39.service.LecturerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueLecturerEmailValidator implements Validator {
    private LecturerService lecturerService;

    public UniqueLecturerEmailValidator(LecturerService lecturerService){
        this.lecturerService = lecturerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Lecturer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Lecturer lecturer = (Lecturer) target;

        if(lecturer.getId() == null
                && this.lecturerService.checkUniqueLecturerEmail(lecturer.getEmail())){
            errors.rejectValue("email", "lecturer.add.email.existsMessage",
                    "Email giảng viên đã tồn tại");
        }
    }
}
