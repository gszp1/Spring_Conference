package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.example.spring_conference.model.Conference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    // Tests if service returns participants that took part in conference with given id
    @Test
    public void DataExists_GetAllParticipantsByConferenceId_CorrectRecords() {

    }

    // Tests if service returns participants that have given role and took part in conference with given id
    @Test
    public void DataExists_GetAllPresentationsByConferenceIdAndRole_CorrectRecords() {

    }

    // Tests if service returns participants that are from given country and took part in conference with given id
    @Test
    public void DataExists_GetAllPresentationsByTopicIdAndCountry_CorrectRecords() {

    }
}
