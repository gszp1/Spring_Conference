package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.example.spring_conference.model.Conference;
import org.example.spring_conference.model.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class ConferenceServiceTests {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private PresentationService presentationService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private PresentationParticipantService presentationParticipantService;

    @BeforeEach
    public void setUp() {
        // Add conference to table
        Conference conference = new Conference();
        conference.setTitle("Title1");
        conference = conferenceService.save(conference);
    }
}
