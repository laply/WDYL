# app 만들기 

# 1. 앱 생성하고 등록하기
여기서 앱은 mysql의 db 처럼 사용되는 것처럼 보인다. 
fapp 부분의 자신이 만들 앱이름을 적으면 생성한다.   

    python manage.py makeapp fapp

setting.py 에 앱 이름을 추가

INSTALLED_APP = [
    ...,
    'fapp',
]

# 2. 생성된 앱에 등록할 정보를 입력한다. 

먼저 현재 프로젝트가 위치한 폴더의 새로운 폴더가 앱이름으로 생겼을 것이다.
구조를 먼저 살펴보자.

fapp/
    __pycache__/
    __init__.py
    admin.py
    apps.py
    models.py
    tests.py
    views.py


// 파일 리스트 정리필요

이중 models.py에 새로 작성할 모델을 작성한다.
여기서 모델은 mysql 의 table 처럼 쓰이는 것처럼 보인다.

    from django.db import models

    class TestModel(models.Model):
        title = models.CharField(max_length=200)
        content = models.TextField()
        view_count = models.IntegerField(default=0)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)

모델은 클래스 기반으로 생성한다. 
여기서는 TestModel 과 그 목록들의 속성정보를 각각 등록했다.

//속성정보에 대한 정리필요 타입 정보 

모델링 하기 

새로 만든 모델을 적용한다. 

    python manage.py makemigration
    python manage.py migrate

makemigration으로 모델을 migrate 할 수 있게 변환하고,
migrate 해서 DB에 적용한다.

migrate 시 새로만든 앱 폴더 안에  migrations 폴더가 생성된다.
    
    fapp/
        ...
        migrations/

    python manage.py shell 

쉘을 통해ㅔ서 데이터를 확인하고 추가할 수 있다.

shell 을 통해 데이터 넣고 정리가능 (정리하는 방법은 찾아봐야함)
