package org.example.spring_conference.service;

import org.example.spring_conference.model.Conference;
import org.example.spring_conference.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public List<Conference> saveAll(List<Conference> conferences) {
        return conferenceRepository.saveAll(conferences);
    }
}
