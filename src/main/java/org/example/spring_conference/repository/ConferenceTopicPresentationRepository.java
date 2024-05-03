package org.example.spring_conference.repository;

import org.example.spring_conference.compositekeys.ConferenceTopicKey;
import org.example.spring_conference.model.ConferenceTopicPresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceTopicPresentationRepository extends
        JpaRepository<ConferenceTopicPresentation, ConferenceTopicKey> {
}
