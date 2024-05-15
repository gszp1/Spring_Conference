package org.example.spring_conference.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParticipantPresentedCountDto {

    private String firstName;

    private String lastName;

    private Long count;
}
