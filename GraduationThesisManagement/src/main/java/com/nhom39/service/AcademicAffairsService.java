package com.nhom39.service;

import com.nhom39.pojo.AcademicAffairs;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface AcademicAffairsService {
    public boolean checkUniqueAcademicAffairsEmail(String academicAffairsEmail);
    public boolean checkUniqueAcademicAffairsPhone(String academicAffairsPhone);
    public List<AcademicAffairs> getAcademicAffairs(Map<String, String> params);
    public long countAcademicAffairs(Map<String, String> params);
    public boolean addAcademicAffairs(AcademicAffairs manage, MultipartFile file);
    public AcademicAffairs getAcademicAffairsById(int academicAffairsId);
    public boolean updateAcademicAffairs(int academicAffairsId, AcademicAffairs academicAffairs, MultipartFile file);
    public boolean deleteAcademicAffairs(int academicAffairsId);
}
