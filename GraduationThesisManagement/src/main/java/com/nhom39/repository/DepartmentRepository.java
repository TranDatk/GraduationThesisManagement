/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentRepository {
    public boolean checkUniqueDepartmentCode(String departmentCode);
    public boolean checkUniqueDepartmentName(String departmentName);
    public List<Department> getDepartments (Map<String, String> params);
    public long countDepartment(Map<String, String> params);
    public List<Object[]> getDepartmentOptions();
    public boolean addDepartment(Department department);
    public boolean checkCodeExists(String code);
    public Department getDepartmentById(int departmentId);
    public boolean updateDepartment(int departmentId, Department department);
    public boolean deleteDepartment (int departmentId);
}
