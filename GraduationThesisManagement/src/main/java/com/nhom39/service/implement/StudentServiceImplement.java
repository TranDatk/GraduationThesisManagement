package com.nhom39.service.implement;

import com.nhom39.constants.SystemConstant;
import com.nhom39.pojo.Student;
import com.nhom39.repository.StudentRepository;
import com.nhom39.service.CloudinaryService;
import com.nhom39.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public boolean checkUniqueStudentCode(String studentCode) {
        return this.studentRepository.checkUniqueStudentCode(studentCode);
    }

    @Override
    public boolean checkUniqueStudentEmail(String studentEmail) {
        return this.studentRepository.checkUniqueStudentEmail(studentEmail);
    }

    @Override
    public boolean checkUniqueStudentPhone(String studentPhone) {
        return this.studentRepository.checkUniqueStudentPhone(studentPhone);
    }

    @Override
    public List<Object[]> getStudentOptions() {
        return this.studentRepository.getStudentOptions();
    }

    @Override
    public List<Student> getStudents(Map<String, String> params) {
        return this.studentRepository.getStudents(params);
    }

    @Override
    public long countStudent(Map<String, String> params) {
        return this.studentRepository.countStudent(params);
    }

    @Override
    public long countAllStudent() {
        return this.studentRepository.countAllStudent();
    }

    @Override
    public Student getStudentById(int studentId) {
        return this.studentRepository.getStudentById(studentId);
    }

    @Override
    public boolean addStudent(Student student, MultipartFile file) {
        String avatarStr = SystemConstant.AVATAR_DEFAULT_URL;

        if (file != null) {
            avatarStr = this.cloudinaryService.uploadAvatar(file);
        }

        student.getUser().setAvatar(avatarStr);
        return this.studentRepository.addStudent(student);
    }

    @Override
    public boolean addStudent(List<Student> students) throws IOException {
        for (Student student : students) {
            if (student.getUser().getAvatar() != null && !student.getUser().getAvatar().isEmpty()) {
                String avatarStr = this.cloudinaryService.uploadAvatar(student.getUser().getAvatar());
                student.getUser().setAvatar(avatarStr);
            }

            if (!this.studentRepository.addStudent(student))
                return false;
        }
        return true;
    }

    @Override
    public boolean updateStudent(int studentId, Student student, MultipartFile file) {
        if (file != null) {
            String avatarStr = this.cloudinaryService.uploadAvatar(file);
            student.getUser().setAvatar(avatarStr);
        }

        return this.studentRepository.updateStudent(studentId, student);
    }

    @Override
    public boolean deleteStudent(int studentId) {
        return this.studentRepository.deleteStudent(studentId);
    }
}
