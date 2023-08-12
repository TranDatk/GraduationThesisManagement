package com.nhom39.repository;

import com.nhom39.pojo.Topic;

import java.util.List;
import java.util.Map;

public interface TopicRepository {
    public boolean checkUniqueTopicName(String topicName);
    public List<Object[]> getTopicOptions();
    public List<Topic> getTopics(Map<String, String> params);
    public long countTopic(Map<String, String> params);
    public boolean addTopic(Topic topic);
    public Topic getTopicById(int topicId);
    public boolean updateTopic(int topicId, Topic topic);
    public boolean deleteTopic (int topicId);
}
