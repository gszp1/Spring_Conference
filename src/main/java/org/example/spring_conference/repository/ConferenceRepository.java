package org.example.spring_conference.repository;

import org.example.spring_conference.model.Conference;
import org.example.spring_conference.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Integer> {

    @Query("SELECT DISTINCT pp.participant FROM PresentationParticipant pp " +
            "JOIN pp.presentation p " +
            "JOIN p.conferenceTopicPresentation ctp " +
            "JOIN ctp.conference c " +
            "WHERE c.conferenceId = :conferenceId"
    )
    List<Participant> getAllParticipantsByConferenceId(@Param("conferenceId") Integer conferenceId);

}
