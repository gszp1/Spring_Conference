package org.example.spring_conference.service;

import org.example.spring_conference.model.ConferenceTopicPresentation;
import org.example.spring_conference.repository.ConferenceTopicPresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceTopicPresentationService {

    private final ConferenceTopicPresentationRepository conferenceTopicPresentationRepository;

    @Autowired
    public ConferenceTopicPresentationService(ConferenceTopicPresentationRepository conferenceTopicPresentationRepository) {
        this.conferenceTopicPresentationRepository = conferenceTopicPresentationRepository;
    }

    public ConferenceTopicPresentation save(ConferenceTopicPresentation conferenceTopicPresentation) {
        return conferenceTopicPresentationRepository.save(conferenceTopicPresentation);
    }

    public List<ConferenceTopicPresentation> saveAll(List<ConferenceTopicPresentation> conferenceTopicPresentations) {
        return conferenceTopicPresentationRepository.saveAll(conferenceTopicPresentations);
    }
}
