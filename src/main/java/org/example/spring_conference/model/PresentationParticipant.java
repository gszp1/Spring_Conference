package org.example.spring_conference.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.spring_conference.compositekeys.PresentationParticipantKey;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "presentations_participants")
public class PresentationParticipant {

    @EmbeddedId
    private PresentationParticipantKey id;

    @ManyToOne
    @MapsId("presentationId")
    @JoinColumn(name = "FK_presentation", nullable = false)
    private Presentation presentation;

    @ManyToOne
    @MapsId("participantId")
    @JoinColumn(name = "FK_participant", nullable = false)
    private Participant participant;
}
