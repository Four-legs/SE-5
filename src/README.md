# 2019.05.21 Log

### Data Handler
- 데이터 관리를 위해 데이터 핸들러 생성, 데이터 save 및 load가 가능
- 저장된 데이터 파일을 불러와서 보드 생성 (맨 처음 Main에서 보드 생성 - 현재 null에 대한 예외 상황 처리 X)

### UI
- Posting : Data 핸들러 사용해서 데이터 직렬화해서 저장 (.dat)
- View : 보드에 있는 NoticeList에서 제목만 가져와서 JList에 Add (이때, 해당 제목들 누르면 index 반환, NoticeList index와 동일)
- View : JList에 있는 아이템 선택 -> 보기 버튼 누르면 제목과 내용에 해당 Notice의 제목, 내용 보여줌 (위의 index )
