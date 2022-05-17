# Reviewproject -
# [AirPlane-Ticketing Sysytem(Java & MySQL CODE)](https://github.com/Money1Kang/Miniproject2/tree/master)
--> IN MASTER BRANCH

# [Airplane-Ticketing(ERD)](https://app.diagrams.net/?libs=general;flowchart#HMoney1Kang%2FMiniproject2%2Fmain%2FAirplane-Ticketing(ERD)) - draw IO 활용
![image](https://user-images.githubusercontent.com/100591948/168666821-6ce95f46-3155-4082-9094-75ceb98eee4f.png)

# Airplane-Ticketing(EER) - MySQL Workbench 활용
![image](https://user-images.githubusercontent.com/100591948/168663262-f383d80c-4315-41cb-ba4d-3c1003171e9f.png)

=====================================================================================================
## 00.팀원 소개 -  강희원, 김도현, 원종혁, 백체은

==================================================================================================
## 01.기술 스택 - JAVA, MySQL

================================================================================================
## 02.기술 명세 - 비행기 티켓 조회

========================================================================================
## 03. 작업내용
-ERD 간단한 회의 뒤, EER 작업 착수
-ERDCloud에서의 EXPORT 추출 실패로 MySQK Workbench로 EER 작업 재착수
 [EER - ErdCloud 작업중](https://www.erdcloud.com/d/yWaJWhivpzF5buTnb)
 
-팀원끼리의 업무량 조절로 간단한 기능구현과 간단한 리뷰형식의 프로젝트 방향설정
-Todo(Step07 in Java)리스트와 비교하면서 클론코딩

==================================================================================================
## 04. 고착점( trouble Shooting )
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

## 05. 느낀점 
 - 원종혁 : 코드만 작성하는 것이 아니라 MySQL을 통해서 설계부터 코드 작성까지 직접 경험해봤는데 설계가 얼마나 중요하고 어려운 것인지 알게 되었습니다. 설계단계에서 차근차근 쌓아가지 않으면 결국 코드를 작성하는 단계 어딘가에서 큰 문제가 생겨서 이도 저도 못하는 경우가 발생할 수 있었습니다. 코드 공부뿐만 아니라 설계 공부도 열심히 해야겠습니다.

- 백체은 : insert를 작성하려는 순간 테이블 구성이 잘못됐다는 생각이 들었다. 하지만 이제 와서 테이블부터 바꿀 수 없어서 최대한 해보려고 했다.
  insert를 join문으로 구성해봤는데 이런저런 런타임 예외를 처리하고 났더니 에러가 나지는 않는데 ticketView.errorPage();가 실행되길래 ticketService.save(newTicket);를 출력해봤더니 0이 나왔다. sql문장에 syntax 에러는 없는데 그럼 이 문장은 뭘하고 온 걸까. 
  그래서 우선 입력한 값에 맞는 id값을 받은 다음에 그걸 다시 insert 문장의 value값에 넣기 위해 select 구문으로 각각의 테이블에서 id 값들을 받아오려고 했는데 column수가 일치하지 않는다며 에러가 났다. 그래서 ticket_id까지 넣어보긴 했는데 update가 아니고 insert를 하고 싶은 거라서 내가 임의로 ticket_id를 설정하는 게 맞나 싶었다. auto increment 설정을 해놨기 때문이다.

그래서 save 메서드 안에서 match라는 메서드를 넣어서 select를 따로 빼려고 했는데 에러가 너무 많이 떠서 가독성이 너무 떨어지고 문제를 파악하기 힘들어서(pstmt가 누구의 pstmt인지 알아보기 너무 힘들었다.) 외부에 match 메서드를 작성해서 return 값을 save의 인자값으로 넣어주려고 했는데, 역시나 에러가 많고 pstmt를 작성하기가 복잡해서 문제를 더 쪼개보기로 했다.
 문제를 더 쪼개보자 해서 passengerId 받는 메서드, destinationId 받는 메서드 등으로 네 개의 메서드로 빼보려고 했는데 return 값으로 id 값을 받는데 compile 에러가 났다. 이걸 passenger_id, destination_id, starting_point_id, airline_id 이렇게 네 개를 받아야 하는데 너무 많은 에러를 해결할 자신이 없었다. 
ticket 테이블이 외부키로 id가 아니라 String값을 받았어야 한다는 생각이 들었다. 테이블 구성 짤 때는 문제를 몰랐다. id 값을 받아도 할 수 있는 사람이 있겠지만 일단 지금의 나는 아닌 것 같아서 속상했다.
insert가 내 정신과 마음을 박살내긴 했지만 문제는 더 있다. 
1. insert에서 입력한 문자열값을 id값과 매칭해서 데이터를 추가할 수 있다면 update도 가능할 거 같은데 막상해보면 다른 방식이 필요하진 않을까? (passenger table이 아니라 ticket table을 update 하고 싶었다.)
2. 왜 builder는 적용이 안 되는지(insert가 내 시간을 훔쳐갔다.)
3. 조회 sql구문을 간소화할 수는 없는지(insert가 생각할 시간을 안 줬다.)

다른 테이블에서 해당하는 id값을 받아와서 그것을 원하는 테이블에 insert하는 방법 아시는 분 있으면 제발 좀 알려주세요, 너무 해결방법이 궁금합니다.

- 김도현 : 설계가 참 중요한 것 같다
- 강희원 : 설계의 깊이; 수정하고, 커밋하고 하는 일을 생각해서 설계를 탄탄히 해야겠다

수고하셔습니다!(원종혁)
