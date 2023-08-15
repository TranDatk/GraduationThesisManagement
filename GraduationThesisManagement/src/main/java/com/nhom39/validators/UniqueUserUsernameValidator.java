package com.nhom39.validators;

import com.nhom39.pojo.User;
import com.nhom39.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueUserUsernameValidator implements Validator {
    private final UserService userService;

    public UniqueUserUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

if(this.userService.checkUniqueUserUsername(user.getUsername())){
    errors.rejectValue("username", "user.add.username.existsMessage",
            "Tên người dùng đã tồn tại");
}
    }
}
