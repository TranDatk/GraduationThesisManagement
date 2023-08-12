package com.nhom39.service;

import com.nhom39.pojo.NotificationUser;

import java.util.List;

public interface NotificationUserService {
    public List<NotificationUser> getNotificationUser(int userId);
    public void turnOffNotification(int notificationUserId);
}
