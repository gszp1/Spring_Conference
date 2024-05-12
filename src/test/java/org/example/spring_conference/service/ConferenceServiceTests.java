package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.example.spring_conference.model.*;
import org.example.spring_conference.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @Autowired
    private RoleService roleService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PresentationRoomService presentationRoomService;

    @BeforeEach
    public void setUp() {
        // Create and save sample roles
        Role role1 = new Role();
        role1.setRole_name("Student");
        roleService.save(role1);

        Role role2 = new Role();
        role2.setRole_name("Scientist");
        roleService.save(role2);

        // Create and save sample countries
        Country country1 = new Country();
        country1.setName("Poland");
        countryService.save(country1);

        Country country2 = new Country();
        country2.setName("Germany");
        countryService.save(country2);

        // Create and save sample participants
        Participant participant1 = new Participant();
        participant1.setFirstName("John");
        participant1.setLastName("Doe");
        participant1.setCountryOfOrigin(country1);
        participant1.setRole(role1);
        participantService.save(participant1);

        Participant participant2 = new Participant();
        participant2.setFirstName("Steve");
        participant2.setLastName("Blum");
        participant2.setCountryOfOrigin(country2);
        participant2.setRole(role2);
        participantService.save(participant2);

        // Create and save sample topics
        Topic topic1 = new Topic();
        topic1.setTitle("Topic 1");
        topicService.save(topic1);

        Topic topic2 = new Topic();
        topic2.setTitle("Topic 2");
        topicService.save(topic2);

        // Create and save sample conferences
        Conference conference1 = new Conference();
        conference1.setTitle("Conference 1");
        conferenceService.save(conference1);

        Conference conference2 = new Conference();
        conference2.setTitle("Conference 2");
        conferenceService.save(conference2);

        // Create and save sample presentations
        Presentation presentation1 = new Presentation();
        presentation1.setDate(LocalDate.now());
        presentation1.setStartTime(LocalTime.now());
        presentation1.setDuration(new Timestamp(System.currentTimeMillis()));
        presentation1.setPresenter(participant1);
        presentationService.save(presentation1);

        Presentation presentation2 = new Presentation();
        presentation2.setDate(LocalDate.now());
        presentation2.setStartTime(LocalTime.now());
        presentation2.setDuration(new Timestamp(System.currentTimeMillis()));
        presentation2.setPresenter(participant2);
        presentationService.save(presentation2);

        // Create and save sample hotels
        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel 1");
        hotel1.setAddress("Address 1");
        hotelService.save(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setName("Hotel 2");
        hotel2.setAddress("Address 2");
        hotelService.save(hotel2);

        // Create and save sample presentation rooms
        PresentationRoom room1 = new PresentationRoom();
        room1.setCapacity(50);
        room1.setHotel(hotel1);
        presentationRoomService.save(room1);

        PresentationRoom room2 = new PresentationRoom();
        room2.setCapacity(100);
        room2.setHotel(hotel2);
        presentationRoomService.save(room2);
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
