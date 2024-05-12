package org.example.spring_conference.service;

import org.example.spring_conference.dto.TopicDto;
import org.example.spring_conference.model.Topic;
import org.example.spring_conference.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> saveAll(List<Topic> topics) {
        return topicRepository.saveAll(topics);
    }

    List<TopicDto> getPresentationsTopicsByConferenceId(Integer conferenceId) {
        return topicRepository.getPresentationsTopicsByConferenceId(conferenceId)
                .stream()
                .map(t -> new TopicDto(t.getTitle()))
                .collect(Collectors.toList()
                );
    }
}
