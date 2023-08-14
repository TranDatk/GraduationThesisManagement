/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.AcademicAffairs;

import java.util.List;
import java.util.Map;

public interface AcademicAffairsRepository {
    public boolean checkUniqueAcademicAffairsEmail(String manageEmail);
    public boolean checkUniqueAcademicAffairsPhone(String managePhone);
    public List<AcademicAffairs> getAcademicAffairs(Map<String, String> params);
    public long countAcademicAffairs(Map<String, String> params);
    public boolean addAcademicAffairs(AcademicAffairs AcademicAffairs);
    public AcademicAffairs getAcademicAffairsById(int manageId);
    public boolean updateAcademicAffairs(int manageId, AcademicAffairs AcademicAffairs);
    public boolean deleteAcademicAffairs(int manageId);
}
