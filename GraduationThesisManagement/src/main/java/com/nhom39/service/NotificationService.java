package com.nhom39.service;

import com.nhom39.pojo.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationService {
    public List<Notification> getNotifications(Map<String, String> params);
    public long countNotification(Map<String, String> params);
    public boolean addNotification(Notification notification, Map<String, String> params);
    public boolean deleteNotification(int notificationId);
}
