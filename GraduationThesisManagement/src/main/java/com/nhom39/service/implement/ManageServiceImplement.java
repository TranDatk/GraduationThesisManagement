package com.nhom39.service.implement;

import com.nhom39.constants.SystemConstant;
import com.nhom39.pojo.Manage;
import com.nhom39.repository.ManageRepository;
import com.nhom39.service.CloudinaryService;
import com.nhom39.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImplement implements ManageService {
    @Autowired
    private ManageRepository manageRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public boolean checkUniqueManageEmail(String manageEmail) {
        return this.manageRepository.checkUniqueManageEmail(manageEmail);
    }

    @Override
    public boolean checkUniqueManagePhone(String managePhone) {
        return this.manageRepository.checkUniqueManagePhone(managePhone);
    }

    @Override
    public List<Manage> getManages(Map<String, String> params) {
        return this.manageRepository.getManages(params);
    }

    @Override
    public long countManage(Map<String, String> params) {
        return this.manageRepository.countManage(params);
    }

    @Override
    public boolean addManage(Manage manage, MultipartFile file) {
        String avatarStr = SystemConstant.AVATAR_DEFAULT_URL;
        if (file != null) {
            avatarStr = this.cloudinaryService.uploadAvatar(file);
        }

        manage.getUser().setAvatar(avatarStr);
        return manageRepository.addManage(manage);
    }

    @Override
    public Manage getManageById(int manageId) {
        return this.manageRepository.getManageById(manageId);
    }

    @Override
    public boolean updateManage(int manageId, Manage manage, MultipartFile file) {
        if (file != null) {
            String avatarStr = this.cloudinaryService.uploadAvatar(file);
            manage.getUser().setAvatar(avatarStr);
        }
        return this.manageRepository.updateManage(manageId, manage);
    }

    @Override
    public boolean deleteManage(int manageId) {
        return this.manageRepository.deleteManage(manageId);
    }

}
