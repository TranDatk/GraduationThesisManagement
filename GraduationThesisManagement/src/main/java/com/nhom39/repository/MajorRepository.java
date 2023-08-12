/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.Major;

import java.util.List;
import java.util.Map;

public interface MajorRepository {
    public boolean checkUniqueMajorCode(String majorCode);
    public boolean checkUniqueMajorName(String majorName);
    public List<Major> getMajors(Map<String, String> params);
    public long countMajor(Map<String, String> params);
    public List<Object[]> getMajorOptions();
    public boolean addMajor(Major major);
    public Major getMajorById(int majorId);
    public boolean updateMajor(int majorId, Major major);
    public boolean deleteMajor (int majorId);
}
