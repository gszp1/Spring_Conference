package org.example.spring_conference.service;

import org.example.spring_conference.repository.PresentationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationRoomService {

    private final PresentationRoomRepository presentationRoomRepository;

    @Autowired
    public PresentationRoomService(PresentationRoomRepository presentationRoomRepository) {
        this.presentationRoomRepository = presentationRoomRepository;
    }
}
