package org.example.spring_conference.repository;

import org.example.spring_conference.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Query("SELECT DISTINCT t FROM Topic t " +
            "JOIN t.conferences c " +
            "JOIN c.presentation p " +
            "WHERE c.id.conferenceId = :conferenceId"
    )
    List<Topic> getPresentationsTopicsByConferenceId(@Param("conferenceId") Integer conferenceId);
}
