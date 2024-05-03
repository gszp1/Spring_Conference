package org.example.spring_conference.service;

import org.example.spring_conference.repository.PresentationParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationParticipantService {

    private final PresentationParticipantRepository presentationParticipantRepository;

    @Autowired
    public PresentationParticipantService(PresentationParticipantRepository presentationParticipantRepository) {
        this.presentationParticipantRepository = presentationParticipantRepository;
    }
}
