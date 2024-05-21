package org.example.spring_conference.compositekeys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class PresentationParticipantKey implements Serializable {

    private int presentationId;

    private int participantId;
}
