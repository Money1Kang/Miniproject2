# Reviewproject - 강희원, 김도현, 원종혁, 백체은
## [AirPlane-Ticketing Sysytem(Java & MySQL CODE)](https://github.com/Money1Kang/Miniproject2/tree/master)
--> IN MASTER BRANCH

# [Airplane-Ticketing(ERD)](https://app.diagrams.net/?libs=general;flowchart#HMoney1Kang%2FMiniproject2%2Fmain%2FAirplane-Ticketing(ERD)) - draw IO 활용
![image](https://user-images.githubusercontent.com/100591948/168666821-6ce95f46-3155-4082-9094-75ceb98eee4f.png)

# Airplane-Ticketing(EER) - MySQL Workbench 활용
![image](https://user-images.githubusercontent.com/100591948/168663262-f383d80c-4315-41cb-ba4d-3c1003171e9f.png)

=====================================================================================================

# 220516 작업일지
-ERD 간단한 회의 뒤, EER 작업 착수
-ERDCloud에서의 EXPORT 추출 실패로 MySQK Workbench로 EER 작업 재착수
 [EER - ErdCloud 작업중](https://www.erdcloud.com/d/yWaJWhivpzF5buTnb)
 
-팀원끼리의 업무량 조절로 간단한 기능구현과 간단한 리뷰형식의 프로젝트 방향설정
-Todo(Step07 in Java)리스트와 비교하면서 클론코딩

==================================================================================================
## 고착점
1.DB설계 부분에서 EER 키 값(참조키, 기본키)설정문제 - (1)참조키만 받는 테이블(Ticket)에 기본키 UN(Unsigned data type), AI(Auto Incremental) 키값 부분에 체크뒤 참조키 4개가 UN 키값체크가 안됨 / 해결방안 : Ticket 테이블에 인스턴스(id)를  만들어 PK설정 후 비식별자 관계설정-> 참조키에 UN설정이 가능해짐 
(2) AI 키값은 PK받는부분에만 설정가능. 반면, 참조키는 값의 반환만 보여주는 식이라 AI(자동증가값) 키값 체크 불가

 ![고착1](https://user-images.githubusercontent.com/100591948/168669238-2d452207-00a6-47c5-8297-1123874069c1.png)

2.In JAVA - DB(MySQL)연동식. INSERT CODE 문제 - 설계 부문에서 데이터를 보여주는 테이블(Ticket)에서 참조키로 id 인스턴스만 받아서 데이터를 설정하는데서의 어려움 / (1) CMD에서 ticket 조회 시 id값만 나열
 ![ticket CMD1](https://user-images.githubusercontent.com/100591948/168673311-7d150951-9a11-4a0d-91ee-ce0c68ce1410.png)

 / 해결방안 : SQL식에 JOIN써서 여러데이터 조회하는 방법 

  ![ticket CMD2](https://user-images.githubusercontent.com/100591948/168673904-fd614c8b-40c4-421f-b4a5-6895d6dbfca8.png)
 
```
<SQL-CMD>
SELECT ticket_id, last_name, first_name, airline, destination, starting_point FROM ticket AS t 
JOIN airline a
ON t.airline_id = a.airline_id 
JOIN destination d
ON t.destination_id = d.destination_id
JOIN passenger p
ON t.passenger_id = p.passenger_id 
JOIN starting_point s
ON t.starting_point_id = s.starting_point_id
ORDER BY ticket_id ASC;
```
/(2) JAVA INSERT 코드부문 / 해결못함(시도 뒤 주석처리)
![INSERT 주석](https://user-images.githubusercontent.com/100591948/168671726-6ad69a92-e6c6-4718-a638-f15e653307a0.png)

============================================================================================

# 느낀점 - 설계의 깊이;;
