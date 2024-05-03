package org.example.spring_conference.service;

import org.example.spring_conference.model.Presentation;
import org.example.spring_conference.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationService {

    private final PresentationRepository presentationRepository;

    @Autowired
    public PresentationService(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public Presentation save(Presentation presentation) {
        return presentationRepository.save(presentation);
    }

    public List<Presentation> saveAll(List<Presentation> presentations) {
        return presentationRepository.saveAll(presentations);
    }
}
