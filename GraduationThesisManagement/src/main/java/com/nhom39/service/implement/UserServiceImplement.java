package com.nhom39.service.implement;

import com.nhom39.pojo.User;
import com.nhom39.repository.UserRepository;
import com.nhom39.req.PasswordUser;
import com.nhom39.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("userDetailsService")
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkUniqueUserUsername(String username) {
        return this.userRepository.checkUniqueUserUsername(username);
    }

    @Override
    public List<Object[]> getUsers(Map<String, String> params) {
        return this.userRepository.getUsers(params);
    }

    @Override
    public List<User> getUsersChat(Map<String, String> params) {
        return this.userRepository.getUsersChat(params);
    }

    @Override
    public Set<Integer> getUsers(Map<String, String> params, List<Integer> usersId) {
        return this.userRepository.getUsers(params, usersId);
    }

    @Override
    public User getUserByUserName(String username) {
        return this.userRepository.getUserByUserName(username);
    }

    @Override
    public void changePassword(int userId, String newPassword) {
        this.userRepository.changePassword(userId, newPassword);
    }

    @Override
    public boolean changePassword(PasswordUser passwordUser) {
        return this.userRepository.changePassword(passwordUser);
    }

    @Override
    public boolean checkPassword(int userId, String password) {
        return this.userRepository.checkPassword(userId,password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByUserName(username);

        if(user == null){
            throw  new UsernameNotFoundException("Username does not exist!!!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
