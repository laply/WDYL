# 관리자 페이지 만들고 설정하기 

서버를 실행 시킨후 admin을 추가해서 실행하면

https://ip:port/admin/

관리자 페이지가 등장한다. superuser를 만들어야 접속이 가능하다.

<img width="552" alt="Django_admin" src="https://user-images.githubusercontent.com/65690925/100123530-f344c880-2ebd-11eb-9b4d-8c5053fe89cf.png">


다시 설정하는 터미널(파일이 존재하는)로 돌아가 superuser를 만들어준다  

    python manager createsuperuser

그 후 각각 username / email / password x 2 를 입력하면 만들어진다.

다시 admin 페이지에 들어가 생성한 아이디와 비밀번호를 입력하면
처음화면에 들어가면 기존에 만들어 두었던 모델을 확인할 수 있다.

// 초기 접속 화면도 필요
<img width="1369" alt="administration_page" src="https://user-images.githubusercontent.com/65690925/100123981-6cdcb680-2ebe-11eb-94c2-02f8a076971c.png">

# 데이터 추가하기

# 데이터 삭제하기

# 데이터 update

# 검색과 표 만들기
