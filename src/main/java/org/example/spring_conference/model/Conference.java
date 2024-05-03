package org.example.spring_conference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conferences")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conference_id")
    private int conferenceId;

    @Column(unique = true, nullable = false)
    private String title;

    @OneToMany(mappedBy = "conference")
    private List<ConferenceTopicPresentation> topics = new ArrayList<>();
}
