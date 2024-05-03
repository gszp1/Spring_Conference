package org.example.spring_conference.repository;

import org.example.spring_conference.compositekeys.PresentationParticipantKey;
import org.example.spring_conference.model.PresentationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationParticipantRepository extends
        JpaRepository<PresentationParticipant, PresentationParticipantKey> {
}
