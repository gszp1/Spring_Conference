# Spring Conference #

## Overwiew ##

Model for attending scientific conference.

## Rules of model ##

1. User can have only one role, but there can be multiple users with given role (ManyToOne).
2. Conference has multiple presentations, but presentation can be part of only one conference(ManyToOne).
3. PresentationRoom can hold multiple presentations, but presentation can take place in only one room. (ManyToOne).
4. To ensure given topic being presented only once per conference a join table is created with
composite key consisting of topicId and conferenceId. Additional connection with presentation
wit unique and non-nullable constraint ensures that given presentation is unique to conference
and that given presentation can be of only one topic.
5. Additionally relationship between presentation and join table is OneToOne,
as given presentation can be shown only on one conference and conference can have only one presentation on given topic.
6. Hotel has multiple presentation rooms, but given presentation room can belong only to one hotel (OneToMany).
