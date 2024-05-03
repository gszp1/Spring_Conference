# Spring Conference #

## Overwiew ##

Model for attending scientific conference.

## Model specifications ##

### Tables (Entity) ###

1. **conferences (Conference)** - informations about conferences.
2. **presentations (Presentation)** - informations about presentations.
3. **topics (Topic)** - informations about topics.
4. **presentation_rooms (PresentationRoom)** - informations about presentation rooms.
5. **hotels (Hotel)** - informations about hotels.
6. **participants (Participant)** - informations about participants.
7. **countries (Country)** - informations about countries.
8. **roles (Role)** - informations about roles.
9. **presentations_participants (PresentationParticipant)** - join table.
10. **conference_topic_presentations (ConfereneceTopicPresentation)** - join table.

### Relationships ###

1. **presentation_rooms - hotels (ManyToOne)**
    - Hotel can have multiple presentation rooms,
    - given room can only belong to one hotel.
2. **participants - countries (ManyToOne)**
    - A participant can originate from one country,
    - there can be multiple participants from given country.
3. **participants - role (ManyToOne)**
    - Participant can have only one role,
    - there can be multile participants with given role.
4. **presentations - presentation_rooms (ManyToOne)**
    - A presentation can be held in only one room,
    - there can be multiple presentations held in one room.
5. **presentations - participants (ManyToMany)**
    - Participant can attend multiple presentations,
    - presentation can be attended by mutliple participants.
6. **presentations - participants (ManyToOne)**
    - Presentation can be presented by only one person,
    - given person can present multiple presentations.
7. **conferences - topics (ManyToMany)**
    - In given conference there can be multiple topics presented,
    - given topic can be presented on multiple conferences.
8. **conference_topic_presentations - presentations (OneToOne)**
    - During conference there can be only one presentation covering given topic.
    - presentation can belong to only one conference.
