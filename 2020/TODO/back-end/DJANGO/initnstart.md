# Django 설치와 Start 하는 방법 

mac os // linux 기반으로 작성


## 1. python3 와 pip3를 설치한다

linux 에서 수행 
sudo apt-get install python3 && sßdo apt-get install python3-pip

## 1.5 가상 환경 구성하기.

// 추가내용 

필자는 goormIDE 컨테이너를 생성하며 수행하였다. 

## 2. Django 설치하기
pip install django
pip3 install django

설치된 장고의 버전을 확인해 실행 확인한다. 
python3 -m django --version

## 3. 새로 장고를 구성할 폴더를만든다.
mkdir django_test && cd django_test


## 3.5 장고 폴더 

site/
    site/
        __init__.py
        setting.py
        urls.py
        asgi.py
        wsgi.py
    manage.py


manage.py: Django 프로젝트와 다양한 방법으로 상호작용 하는 커맨드라인의 유틸리티 입니다. manage.py 에 대한 자세한 정보는 django-admin and manage.py 에서 확인할 수 있습니다.
mysite/ 디렉토리 내부에는 프로젝트를 위한 실제 Python 패키지들이 저장됩니다. 이 디렉토리 내의 이름을 이용하여, (mysite.urls 와 같은 식으로) 프로젝트의 어디서나 Python 패키지들을 임포트할 수 있습니다.
mysite/__init__.py: Python으로 하여금 이 디렉토리를 패키지처럼 다루라고 알려주는 용도의 단순한 빈 파일입니다. Python 초심자라면, Python 공식 홈페이지의 패키지를 읽어보세요.
mysite/settings.py: 현재 Django 프로젝트의 환경 및 구성을 저장합니다. Django settings에서 환경 설정이 어떻게 동작하는지 확인할 수 있습니다.
mysite/urls.py: 현재 Django project 의 URL 선언을 저장합니다. Django 로 작성된 사이트의 《목차》 라고 할 수 있습니다. URL dispatcher 에서 URL 에 대한 자세한 내용을 읽어보세요.
mysite/asgi.py: An entry-point for ASGI-compatible web servers to serve your project. See How to deploy with ASGI for more details.
mysite/wsgi.py: 현재 프로젝트를 서비스하기 위한 WSGI 호환 웹 서버의 진입점입니다. How to deploy with WSGI를 읽어보세요.

각각의 파일 별 기능 정리 필요


## 4. 장고 프레임워크 로드하기 

django-admin startproject mytestsite && cd mytestsite

여기서 mytestsite는 프레임워크가 설치될 폴더명 이다.



## 5. 실행과 실행확인 

새로 생성된 폴더 내부에서 runserver 명령과 manage.py를 
이용하여 웹서버를 실행할 수 있다.

python3 manage.py runserver  


실행 되었다면 아래의 위치에서 확인가능하다.

http://127.0.0.1:8000/ 



<img width="672" alt="Django_first_start" src="https://user-images.githubusercontent.com/65690925/100123658-1b342c00-2ebe-11eb-8bae-227201f16c0c.png">

