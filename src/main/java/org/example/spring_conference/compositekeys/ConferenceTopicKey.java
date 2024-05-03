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
public class ConferenceTopicKey {

    private int conferenceId;

    private int topicId;
}
