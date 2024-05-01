package org.example.spring_conference.model;

import jakarta.persistence.*;
import org.example.spring_conference.compositekeys.ConferenceTopicKey;

@Entity
@Table(name = "conference_topic_presentations")
public class ConferenceTopicPresentation {

    @EmbeddedId
    private ConferenceTopicKey id;

    @ManyToOne
    @MapsId("conferenceId")
    @JoinColumn(name = "FK_conference", nullable = false)
    private Conference conference;

    @ManyToOne
    @MapsId("topicId")
    @JoinColumn(name = "FK_topic", nullable = false)
    private Topic topic;

    @OneToOne
    @JoinColumn(name = "FK_presentation", nullable = false, unique = true)
    private Presentation presentation;
}
