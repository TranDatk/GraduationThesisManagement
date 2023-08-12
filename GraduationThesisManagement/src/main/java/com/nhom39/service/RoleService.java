package com.nhom39.service;

import com.nhom39.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoles(String kw);
    public List<Object[]> getRoleOptions(String[] exceptRole);
    public Role getRoleByRoleName(String roleName);
}
