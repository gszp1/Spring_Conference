package org.example.spring_conference.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomPresentationsCountDto {

    private int roomId;

    private Long count;
}
