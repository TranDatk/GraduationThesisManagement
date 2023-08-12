package com.nhom39.service.implement;

import com.nhom39.pojo.Topic;
import com.nhom39.repository.TopicRepository;
import com.nhom39.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImplement implements TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public boolean checkUniqueTopicName(String topicName) {
        return this.topicRepository.checkUniqueTopicName(topicName);
    }

    @Override
    public List<Object[]> getTopicOptions() {
        return this.topicRepository.getTopicOptions();
    }

    @Override
    public List<Topic> getTopics(Map<String, String> params) {
        return this.topicRepository.getTopics(params);
    }

    @Override
    public long countTopic(Map<String, String> params) {
        return this.topicRepository.countTopic(params);
    }

    @Override
    public boolean addTopic(Topic topic) {
        return this.topicRepository.addTopic(topic);
    }

    @Override
    public Topic getTopicById(int topicId) {
        return this.topicRepository.getTopicById(topicId);
    }

    @Override
    public boolean updateTopic(int topicId, Topic topic) {
        return this.topicRepository.updateTopic(topicId, topic);
    }

    @Override
    public boolean deleteTopic(int topicId) {
        return this.topicRepository.deleteTopic(topicId);
    }
}
