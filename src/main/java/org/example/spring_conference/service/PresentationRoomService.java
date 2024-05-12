package org.example.spring_conference.service;

import org.example.spring_conference.dto.RoomPresentationsCountDto;
import org.example.spring_conference.model.PresentationRoom;
import org.example.spring_conference.repository.PresentationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationRoomService {

    private final PresentationRoomRepository presentationRoomRepository;

    @Autowired
    public PresentationRoomService(PresentationRoomRepository presentationRoomRepository) {
        this.presentationRoomRepository = presentationRoomRepository;
    }

    public PresentationRoom save(PresentationRoom presentationRoom) {
        return presentationRoomRepository.save(presentationRoom);
    }

    public List<PresentationRoom> saveAll(List<PresentationRoom> presentationRooms) {
        return presentationRoomRepository.saveAll(presentationRooms);
    }

    List<RoomPresentationsCountDto> getPresentationCountByRoom() {
        return presentationRoomRepository.getPresentationCountByRoom();
    }
}
