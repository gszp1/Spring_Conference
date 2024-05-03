package org.example.spring_conference.service;

import org.example.spring_conference.model.Participant;
import org.example.spring_conference.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public List<Participant> saveAll(List<Participant> participants) {
        return participantRepository.saveAll(participants);
    }
}
