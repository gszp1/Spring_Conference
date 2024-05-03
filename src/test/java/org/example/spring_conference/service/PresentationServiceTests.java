package org.example.spring_conference.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class PresentationServiceTests {

    @BeforeEach
    void setUp() {

    }

    // Tests if service returns each topic that is presented during at least one presentation
    @Test
    public void DataExists_GetAllPresentationsTopics() {

    }
}
