package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.example.spring_conference.compositekeys.ConferenceTopicKey;
import org.example.spring_conference.compositekeys.PresentationParticipantKey;
import org.example.spring_conference.model.*;
import org.example.spring_conference.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

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

    @Autowired
    private ConferenceTopicPresentationService conferenceTopicPresentationService;

    @BeforeEach
    public void setUp() {
        // Create and save sample roles
        Role role1 = new Role();
        role1.setRole_name("Student");
        role1 = roleService.save(role1);

        Role role2 = new Role();
        role2.setRole_name("Scientist");
        role2 = roleService.save(role2);

        // Create and save sample countries
        Country country1 = new Country();
        country1.setName("Poland");
        country1 = countryService.save(country1);

        Country country2 = new Country();
        country2.setName("Germany");
        country2 = countryService.save(country2);

        // Create and save sample hotels
        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel 1");
        hotel1.setAddress("Address 1");
        hotel1 = hotelService.save(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setName("Hotel 2");
        hotel2.setAddress("Address 2");
        hotel2 = hotelService.save(hotel2);

        // Create and save sample presentation rooms
        PresentationRoom room1 = new PresentationRoom();
        room1.setCapacity(50);
        room1.setHotel(hotel1);
        room1 = presentationRoomService.save(room1);

        PresentationRoom room2 = new PresentationRoom();
        room2.setCapacity(100);
        room2.setHotel(hotel2);
        room2 = presentationRoomService.save(room2);

        PresentationRoom room3 = new PresentationRoom();
        room3.setCapacity(70);
        room3.setHotel(hotel1);
        room3 = presentationRoomService.save(room3);

        // add presentation rooms to hotels
        hotel2.getPresentationRooms().add(room3);
        hotel1.getPresentationRooms().add(room2);
        hotel1.getPresentationRooms().add(room1);
        hotel1 = hotelService.save(hotel1);
        hotel2 = hotelService.save(hotel2);

        // Create and save sample topics
        Topic topic1 = new Topic();
        topic1.setTitle("Topic 1");
        topic1 = topicService.save(topic1);

        Topic topic2 = new Topic();
        topic2.setTitle("Topic 2");
        topic2 = topicService.save(topic2);

        // Create and save sample conferences
        Conference conference1 = new Conference();
        conference1.setTitle("Conference 1");
        conference1 = conferenceService.save(conference1);

        Conference conference2 = new Conference();
        conference2.setTitle("Conference 2");
        conference2 = conferenceService.save(conference2);

        // Create and save sample participants
        Participant participant1 = new Participant();
        participant1.setFirstName("John");
        participant1.setLastName("Doe");
        participant1.setCountryOfOrigin(country1);
        participant1.setRole(role1);
        participant1 = participantService.save(participant1);

        Participant participant2 = new Participant();
        participant2.setFirstName("Steve");
        participant2.setLastName("Blum");
        participant2.setCountryOfOrigin(country2);
        participant2.setRole(role2);
        participant2 = participantService.save(participant2);

        // Create and save sample presentations
        Presentation presentation1 = new Presentation();
        presentation1.setDate(LocalDate.now().minusDays(1));
        presentation1.setStartTime(LocalTime.now().plusHours(1));
        presentation1.setDuration(new Timestamp(System.currentTimeMillis()));
        presentation1.setPresenter(participant1);
        presentation1 = presentationService.save(presentation1);

        Presentation presentation2 = new Presentation();
        presentation2.setDate(LocalDate.now().plusDays(2));
        presentation2.setStartTime(LocalTime.now().plusHours(2));
        presentation2.setDuration(new Timestamp(System.currentTimeMillis()));
        presentation2.setPresenter(participant2);
        presentation2 = presentationService.save(presentation2);

        // save presenters
        participant1.getPresentedPresentations().add(presentation1);
        participant2.getPresentedPresentations().add(presentation2);
        participant1 = participantService.save(participant1);
        participant2 =  participantService.save(participant2);

        // Add participants to presentations
        PresentationParticipantKey key1 = new PresentationParticipantKey();
        key1.setPresentationId(presentation2.getPresentationId());
        key1.setParticipantId(participant1.getParticipantId());
        PresentationParticipant presentationParticipant1 = new PresentationParticipant();
        presentationParticipant1.setId(key1);
        presentationParticipant1.setPresentation(presentation2);
        presentationParticipant1.setParticipant(participant1);
        presentationParticipant1 =  presentationParticipantService.save(presentationParticipant1);

        PresentationParticipantKey key2 = new PresentationParticipantKey();
        key2.setPresentationId(presentation1.getPresentationId());
        key2.setParticipantId(participant2.getParticipantId());
        PresentationParticipant presentationParticipant2 = new PresentationParticipant();
        presentationParticipant2.setId(key2);
        presentationParticipant2.setPresentation(presentation1);
        presentationParticipant2.setParticipant(participant2);
        presentationParticipant2 =  presentationParticipantService.save(presentationParticipant2);

        // set connections
        // presentationParticipant1 presentation2 participant1
        presentation2.getPresentationParticipants().add(presentationParticipant1);
        participant1.getPresentationParticipants().add(presentationParticipant1);
        // presentationParticipant2 presentation1 participant2
        presentation1.getPresentationParticipants().add(presentationParticipant2);
        participant2.getPresentationParticipants().add(presentationParticipant2);
        presentation1 = presentationService.save(presentation1);
        presentation2 = presentationService.save(presentation2);
        participant1 = participantService.save(participant1);
        participant2 = participantService.save(participant2);

        // Create conference_topic_presentations sample data
        ConferenceTopicKey conferenceTopicKey1 = new ConferenceTopicKey(conference1.getConferenceId(), topic1.getTopicId());
        ConferenceTopicPresentation conferenceTopicPresentation1 = new ConferenceTopicPresentation();
        conferenceTopicPresentation1.setId(conferenceTopicKey1);
        conferenceTopicPresentation1.setConference(conference1);
        conferenceTopicPresentation1.setTopic(topic1);
        conferenceTopicPresentation1.setPresentation(presentation1);
        conferenceTopicPresentation1 =  conferenceTopicPresentationService.save(conferenceTopicPresentation1);

        ConferenceTopicKey conferenceTopicKey2 = new ConferenceTopicKey(conference2.getConferenceId(), topic2.getTopicId());
        ConferenceTopicPresentation conferenceTopicPresentation2 = new ConferenceTopicPresentation();
        conferenceTopicPresentation2.setId(conferenceTopicKey2);
        conferenceTopicPresentation2.setConference(conference2);
        conferenceTopicPresentation2.setTopic(topic2);
        conferenceTopicPresentation2.setPresentation(presentation2);
        conferenceTopicPresentation2 = conferenceTopicPresentationService.save(conferenceTopicPresentation2);

        // create connections
        // 1.) conference1, topic1, presentation1
        conference1.getTopics().add(conferenceTopicPresentation1);
        presentation1.setConferenceTopicPresentation(conferenceTopicPresentation1);
        topic1.getConferences().add(conferenceTopicPresentation1);
        // 2.) conference2, topic2, presentation2
        conference2.getTopics().add(conferenceTopicPresentation2);
        presentation2.setConferenceTopicPresentation(conferenceTopicPresentation2);
        topic2.getConferences().add(conferenceTopicPresentation2);
        conferenceService.saveAll(Arrays.asList(conference1, conference2));
        topicService.saveAll(Arrays.asList(topic1, topic2));
        presentationService.saveAll(Arrays.asList(presentation1, presentation2));
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
