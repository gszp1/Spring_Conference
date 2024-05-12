package org.example.spring_conference.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParticipantPresentedCountDto {

    private String firstName;

    private String lastName;

    private Long count;
}
