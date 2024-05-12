package org.example.spring_conference.service;

import org.example.spring_conference.dto.ParticipantCountryDto;
import org.example.spring_conference.dto.ParticipantDto;
import org.example.spring_conference.dto.TopicDto;
import org.example.spring_conference.model.Conference;
import org.example.spring_conference.model.Topic;
import org.example.spring_conference.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final TopicService topicService;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository, TopicService topicService) {
        this.conferenceRepository = conferenceRepository;
        this.topicService = topicService;
    }

    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public List<Conference> saveAll(List<Conference> conferences) {
        return conferenceRepository.saveAll(conferences);
    }

}
