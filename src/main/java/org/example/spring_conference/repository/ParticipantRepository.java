package org.example.spring_conference.repository;

import org.example.spring_conference.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    @Query("SELECT DISTINCT pp.participant FROM PresentationParticipant pp " +
            "JOIN pp.presentation p " +
            "JOIN p.conferenceTopicPresentation ctp " +
            "JOIN ctp.conference c " +
            "WHERE c.conferenceId = :conferenceId"
    )
    List<Participant> getAllParticipantsByConferenceId(@Param("conferenceId") Integer conferenceId);

    @Query("SELECT DISTINCT p FROM Role r " +
            "JOIN r.participants p " +
            "JOIN p.presentationParticipants pp " +
            "JOIN pp.presentation pr " +
            "JOIN pr.conferenceTopicPresentation ctp " +
            "JOIN ctp.conference c " +
            "WHERE c.conferenceId = :conferenceId " +
            "AND r.roleName = :role"
    )
    List<Participant> getAllParticipantsByConferenceIdAndRole(@Param("conferenceId") Integer conferenceId,
                                                              @Param("role") String roleName);

    @Query("SELECT DISTINCT p FROM Country ct " +
            "JOIN ct.participants p " +
            "JOIN p.presentationParticipants pp " +
            "JOIN pp.presentation pr " +
            "JOIN pr.conferenceTopicPresentation ctp " +
            "JOIN ctp.conference c " +
            "WHERE c.conferenceId = :conferenceId " +
            "AND ct.name = :country"
    )
    List<Participant> getAllParticipantsByConferenceIdAndCountry(@Param("conferenceId") Integer conferenceId,
                                                                 @Param("country") String countryName);
}
