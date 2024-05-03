package org.example.spring_conference.compositekeys;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class PresentationParticipantKey {

    private int presentationId;

    private int participantId;
}
