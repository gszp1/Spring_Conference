package org.example.spring_conference.service;

import org.example.spring_conference.model.PresentationParticipant;
import org.example.spring_conference.repository.PresentationParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationParticipantService {

    private final PresentationParticipantRepository presentationParticipantRepository;

    @Autowired
    public PresentationParticipantService(PresentationParticipantRepository presentationParticipantRepository) {
        this.presentationParticipantRepository = presentationParticipantRepository;
    }

    public PresentationParticipant save(PresentationParticipant presentationParticipant){
        return presentationParticipantRepository.save(presentationParticipant);
    }

    public List<PresentationParticipant> saveAll(List<PresentationParticipant> presentationParticipants){
        return presentationParticipantRepository.saveAll(presentationParticipants);
    }
}
