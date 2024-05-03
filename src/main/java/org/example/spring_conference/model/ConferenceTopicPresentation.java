package org.example.spring_conference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spring_conference.compositekeys.ConferenceTopicKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
