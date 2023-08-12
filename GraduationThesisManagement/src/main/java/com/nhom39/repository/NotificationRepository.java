package com.nhom39.repository;

import com.nhom39.pojo.Notification;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface NotificationRepository {
    public List<Notification> getNotifications (Map<String, String> params);
    public long countNotification(Map<String, String> params);
    public boolean addNotification(Notification notification, Set<Integer> usersId);
    public boolean deleteNotification(int notificationId);
}
