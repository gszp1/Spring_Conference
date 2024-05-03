package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class PresentationRoomServiceTests {

    @BeforeEach
    void setUp() {

    }

    // Tests if service returns correct number of presentations for each room
    @Test
    public void DataExists_GetNumberOfPresentationsForEachRoom_CorrectNumbers() {

    }
}
