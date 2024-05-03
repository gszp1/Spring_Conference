package org.example.spring_conference.repository;

import org.example.spring_conference.model.PresentationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRoomRepository extends JpaRepository<PresentationRoom, Integer> {
}
