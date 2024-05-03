package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class ParticipantServiceTests {

    @BeforeEach
    void setUp() {

    }

    // Tests if service returns participant who presented the largest number of presentations
    @Test
    public void DataExists_GetParticipantWhoPresentedLargestNumberOfPresentations_CorrectParticipant() {

    }
}
