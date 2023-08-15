package com.nhom39.validators;

import com.nhom39.pojo.Topic;
import com.nhom39.service.TopicService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueTopicNameValidator implements Validator {
    private final TopicService topicService;

    public UniqueTopicNameValidator(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Topic.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Topic topic = (Topic) target;

        if (topic.getId() == null && this.topicService.checkUniqueTopicName(topic.getName())) {
            errors.rejectValue("name", "topic.add.name.existsMessage",
                    "Tên đề tài đã tồn tại");
        }

    }
}
