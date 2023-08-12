package com.nhom39.repository;

import com.nhom39.pojo.NotificationUser;

import java.util.List;
import java.util.Set;

public interface NotificationUserRepository {
    public boolean addNotificationUser(int notificationId, Set<Integer> usersId);
    public List<NotificationUser> getNotificationUser(int userId);
    public void turnOffNotification(int notificationUserId);
}
