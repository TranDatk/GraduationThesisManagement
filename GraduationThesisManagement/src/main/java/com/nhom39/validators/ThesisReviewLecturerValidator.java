package com.nhom39.validators;

import com.nhom39.pojo.Lecturer;
import com.nhom39.pojo.Thesis;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class ThesisReviewLecturerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Thesis.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Thesis thesis = (Thesis) target;

       if(thesis.getLecturers().contains(thesis.getReviewLecturer())){
           errors.rejectValue("reviewLecturer",
                   "thesis.add.reviewLecturer.uniqueWithLecturers",
                   "Giảng viên phản biện phải khác giảng viên hướng dẫn");
       }
    }
}
