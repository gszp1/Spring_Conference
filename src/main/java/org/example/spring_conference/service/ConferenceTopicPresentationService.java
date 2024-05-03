package org.example.spring_conference.service;

import org.example.spring_conference.repository.ConferenceTopicPresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceTopicPresentationService {

    private final ConferenceTopicPresentationRepository conferenceTopicPresentationRepository;

    @Autowired
    public ConferenceTopicPresentationService(ConferenceTopicPresentationRepository conferenceTopicPresentationRepository) {
        this.conferenceTopicPresentationRepository = conferenceTopicPresentationRepository;
    }
}
