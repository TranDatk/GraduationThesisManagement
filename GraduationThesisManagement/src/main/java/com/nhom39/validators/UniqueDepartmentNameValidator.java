package com.nhom39.validators;

import com.nhom39.pojo.Department;
import com.nhom39.service.DepartmentService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueDepartmentNameValidator implements Validator {
    private final DepartmentService departmentService;

    public UniqueDepartmentNameValidator(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Department.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Department department = (Department) target;

        if(department.getId() == null
                && this.departmentService.checkUniqueDepartmentName(department.getName())){
            errors.rejectValue("name", "department.add.name.existsMessage",
                    "Tên khoa đã tồn tại");
        }
    }
}
