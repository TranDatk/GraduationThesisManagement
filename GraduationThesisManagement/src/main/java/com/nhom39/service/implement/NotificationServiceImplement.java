package com.nhom39.service.implement;

import com.nhom39.pojo.Notification;
import com.nhom39.repository.NotificationRepository;
import com.nhom39.repository.UserRepository;
import com.nhom39.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class NotificationServiceImplement implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Notification> getNotifications(Map<String, String> params) {
        return this.notificationRepository.getNotifications(params);
    }

    @Override
    public long countNotification(Map<String, String> params) {
        return this.notificationRepository.countNotification(params);
    }

    @Override
    public boolean addNotification(Notification notification,
                                   Map<String, String> params) {
        Set<Integer> usersId = userRepository.getUsers(params, Arrays.asList(notification.getUsersId()));
        return this.notificationRepository.addNotification(notification, usersId);
    }

    @Override
    public boolean deleteNotification(int notificationId) {
        return this.notificationRepository.deleteNotification(notificationId);
    }
}
