/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.Lecturer;
import com.nhom39.pojo.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LecturerRepository {
    public boolean checkUniqueLecturerCode(String lecturerCode);
    public boolean checkUniqueLecturerEmail(String lecturerEmail);
    public boolean checkUniqueLecturerPhone(String lecturerPhone);
    public List<Object[]> getLecturerOptions (String isMinistry);
    public List<Lecturer> getLecturers(Map<String, String> params);
    public long countLecturer(Map<String, String> params);
    public long countAllLecturer();
    public Lecturer getLecturerById(int lecturerId);
    public boolean addLecturer(Lecturer lecturer);
    public boolean updateLecturer(int lecturerId, Lecturer lecturer);
    public boolean deleteLecturer(int lecturerId);
}
