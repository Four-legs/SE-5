# 2019.05.28 Log

### Database
- 학생 데이터로 데이터베이스 구성

### UI
- 뒤로 가기 기능 구현
- Recruit : JList에는 캘린더 구현이 안 되어서 일단은 전체 Notice가 나오도록 했고, Notice 선택하고 선발을 누르면 ManagerOperation의
           Recruiting 메소드 실행 (선발 기준 정해둠)
- Request : 공지 선택하고, 신청을 누르면 본인 인증 번호를 입력하고 신청 완료가 되면 StudentOperation의 Requesting 메소드 실행 및 Save
- Edit : UI만 완성
- RequestView : StudentOperation이 가지고 있는 Student 객체에서 ReqList를 가져와서 해당 객체의 신청 목록을 JList에 보여줌
               하지만, Request와 Recruit의 데이터 직렬화 X, 저장 X -> 구현 필요
               
### 테스트
- 학생 : 공지 조회, 신청, 신청 현황 조회 (신청하고 뒤로 가기해서 해야 함) 가능
- 관리자 : 공지 게시, 조회, 삭제 가능
