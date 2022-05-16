# Reviewproject2
# [이전](https://github.com/Money1Kang/Miniproject2/tree/main)


```
<SQL 문 - airplane>
테이블은 EER에서 생성뒤 사용

--passenger table--
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('인성', '조', '2000-02-02');
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('혜수', '김', '2000-01-01');
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('태현', '차', '2000-03-03');
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('효주', '한', '2000-04-04');
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('광수', '이', '2000-05-05');
INSERT INTO passenger (first_name, last_name, birth_date) VALUES ('우빈', '김', '2000-06-06');

--destination table--
INSERT INTO destination (destination) VALUES ('부다페스트');
INSERT INTO destination (destination) VALUES ('취리히');
INSERT INTO destination (destination) VALUES ('하와이');
INSERT INTO destination (destination) VALUES ('뉴욕');
INSERT INTO destination (destination) VALUES ('베이징');


--starting_point table--
NSERT INTO starting_point (starting_point) VALUES ('도쿄');
INSERT INTO starting_point (starting_point) VALUES ('런던');
INSERT INTO starting_point (starting_point) VALUES ('시드니');
INSERT INTO starting_point (starting_point) VALUES ('서울');
INSERT INTO starting_point (starting_point) VALUES ('다합');

--ticket table에 다른 table 데이터 INSERT-- 
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (1, 1, 1, 1);
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (2, 2, 2, 2);
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (3, 3, 3, 3);
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (4, 4, 4, 1);
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (5, 5, 5, 2);
INSERT INTO ticket (passenger_id, destination_id, starting_point_id, airline_id) VALUES (6, 5, 5, 2);

--JAVA 에 넣은 ticket SQL문--
SELECT ticket_id, last_name, first_name, airline, destination, starting_point 
FROM ticket AS t 
JOIN airline a
ON t.airline_id = a.airline_id 
JOIN destination d
ON t.destination_id = d.destination_id
JOIN passenger p
ON t.passenger_id = p.passenger_id 
JOIN starting_point s
ON t.starting_point_id = s.starting_point_id
ORDER BY ticket_id ASC;

or

SELECT ticket_id, last_name, first_name, airline, starting_point, destination
FROM ticket 
JOIN airline
ON ticket.airline_id = airline.airline_id
JOIN starting_point
ON ticket.starting_point_id = starting_point.starting_point_id
JOIN passenger
ON ticket.passenger_id = passenger.passenger_id
JOIN destination
ON ticket.destination_id = destination.destination_id
ORDER BY ticket_id ASC;

```
