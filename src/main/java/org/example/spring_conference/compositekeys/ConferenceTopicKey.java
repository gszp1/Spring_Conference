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
public class ConferenceTopicKey implements Serializable {

    private int conferenceId;

    private int topicId;
}
