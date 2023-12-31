package com.nhom39.constants;

public class SystemConstant {
    // pagination
    public static final int PAGE_SIZE = 10;

    // validator
    public static final int MAX_NUMBER_OF_TEACHER_INSTRUCTIONS = 2; // Số lượng giảng viên hướng dẫn tối đa
    
    public static final int MAXIMUM_NUMBER_OF_STUDENTS_PERFORMED = 2; // Số lượng sinh viên thực hiện 1 khóa luận tối đa
    public static final int MIN_NUMBER_MEMBER_OF_COUNCIL = 3;
    public static final int MAX_NUMBER_MEMBER_OF_COUNCIL = 5;
    public static final int MAX_THESIS_OF_COUNCIL = 5;

    // mail
    public static final int REVIEW_LECTURER_EMAIL_TEMPLATE = 1;
    public static final int THESIS_RESULT_EMAIL_TEMPLATE = 2;

    // role name
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_MINISTRY = "MINISTRY";
    public static final String ROLE_LECTURER = "LECTURER";
    public static final String ROLE_STUDENT = "STUDENT";

    //score pass
    public static final double SCORE_PASS = 5.0;

    // avatar default
    public static final String AVATAR_DEFAULT_URL = "https://res.cloudinary.com/dtnpj540t/image/upload/v1661526519/GraduationThesisManagementSystem/ipklz9n8lljcb9yxagk3.jpg";
}
