/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.Manage;

import java.util.List;
import java.util.Map;

public interface ManageRepository {
    public boolean checkUniqueManageEmail(String manageEmail);
    public boolean checkUniqueManagePhone(String managePhone);
    public List<Manage> getManages(Map<String, String> params);
    public long countManage(Map<String, String> params);
    public boolean addManage(Manage manage);
    public Manage getManageById(int manageId);
    public boolean updateManage(int manageId, Manage manage);
    public boolean deleteManage(int manageId);
}
