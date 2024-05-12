package org.example.spring_conference.repository;

import org.example.spring_conference.dto.RoomPresentationsCountDto;
import org.example.spring_conference.model.PresentationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresentationRoomRepository extends JpaRepository<PresentationRoom, Integer> {

    @Query("SELECT NEW org.example.spring_conference.dto.RoomPresentationsCountDto(pr.roomId, COUNT(p.presentationId)) " +
            "FROM PresentationRoom pr " +
            "LEFT JOIN pr.presentations p " +
            "GROUP BY pr.roomId " +
            "ORDER BY pr.roomId"
    )
    List<RoomPresentationsCountDto> getPresentationCountByRoom();
}
