package org.example.spring_conference.service;

import org.example.spring_conference.dto.ParticipantCountryDto;
import org.example.spring_conference.dto.ParticipantDto;
import org.example.spring_conference.model.Participant;
import org.example.spring_conference.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ParticipantDto> getAllParticipantsByConferenceId(Integer conferenceId) {
        return participantRepository.getAllParticipantsByConferenceId(conferenceId)
                .stream()
                .map(p -> new ParticipantDto(p.getFirstName(), p.getLastName(), p.getRole().getRoleName()))
                .collect(Collectors.toList()
                );
    }

    public List<ParticipantDto> getAllParticipantsByConferenceIdAndRole(Integer conferenceId, String role) {
        return participantRepository.getAllParticipantsByConferenceIdAndRole(conferenceId, role)
                .stream()
                .map(p-> new ParticipantDto(p.getFirstName(), p.getLastName(), p.getRole().getRoleName()))
                .collect(Collectors.toList()
                );
    }

    public List<ParticipantCountryDto> getParticipantsByConferenceIdAndCountry(Integer conferenceId, String country) {
        return participantRepository.getAllParticipantsByConferenceIdAndCountry(conferenceId, country)
                .stream()
                .map(p -> new ParticipantCountryDto(p.getFirstName(), p.getLastName(), p.getCountryOfOrigin().getName()))
                .collect(Collectors.toList()
                );
    }
}
