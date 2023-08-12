package com.nhom39.service;

import com.nhom39.pojo.Lecturer;
import com.nhom39.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReadExcelService {
    public List<Student> getStudentsFromFile(MultipartFile file);
    public List<Lecturer> getLecturersFromFile(MultipartFile file);
}
