package com.nhom39.service.implement;

import com.nhom39.constants.SystemConstant;
import com.nhom39.pojo.AcademicAffairs;
import com.nhom39.repository.AcademicAffairsRepository;
import com.nhom39.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import com.nhom39.service.AcademicAffairsService;

@Service
public class AcademicAffairsServiceImplement implements AcademicAffairsService {
    @Autowired
    private AcademicAffairsRepository AcademicAffairsRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public boolean checkUniqueAcademicAffairsEmail(String academicAffairsEmail) {
        return this.AcademicAffairsRepository.checkUniqueAcademicAffairsEmail(academicAffairsEmail);
    }

    @Override
    public boolean checkUniqueAcademicAffairsPhone(String managePhone) {
        return this.AcademicAffairsRepository.checkUniqueAcademicAffairsPhone(managePhone);
    }

    @Override
    public List<AcademicAffairs> getAcademicAffairs(Map<String, String> params) {
        return this.AcademicAffairsRepository.getAcademicAffairs(params);
    }

    @Override
    public long countAcademicAffairs(Map<String, String> params) {
        return this.AcademicAffairsRepository.countAcademicAffairs(params);
    }

    @Override
    public boolean addAcademicAffairs(AcademicAffairs manage, MultipartFile file) {
        String avatarStr = SystemConstant.AVATAR_DEFAULT_URL;
        if (file != null) {
            avatarStr = this.cloudinaryService.uploadAvatar(file);
        }

        manage.getUser().setAvatar(avatarStr);
        return AcademicAffairsRepository.addAcademicAffairs(manage);
    }

    @Override
    public AcademicAffairs getAcademicAffairsById(int manageId) {
        return this.AcademicAffairsRepository.getAcademicAffairsById(manageId);
    }

    @Override
    public boolean updateAcademicAffairs(int manageId, AcademicAffairs manage, MultipartFile file) {
        if (file != null) {
            String avatarStr = this.cloudinaryService.uploadAvatar(file);
            manage.getUser().setAvatar(avatarStr);
        }
        return this.AcademicAffairsRepository.updateAcademicAffairs(manageId, manage);
    }

    @Override
    public boolean deleteAcademicAffairs(int manageId) {
        return this.AcademicAffairsRepository.deleteAcademicAffairs(manageId);
    }

}
