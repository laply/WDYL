# Linux / Apache2 / PHP / Mysql

## 1. linux 설치하기 

2020.11.18 기준 ubuntu 20.04.1 version 사용 

linux 서버를 돌리기 위해 

Oracle VM VirtualBox를 먼저 설치한다. 
https://www.virtualbox.org/

virtualBox는 많이 사용하기도 했었고 VMWare와는 달리 무료로 이용할 수 있다. 
가상 머신을 돌리기 쉽게 되어있어 사용하기 편하다.

그 외의 방법은 aws, azure를 사용해서 서버를 구성해도 되고,
 최근에 장고를 연습할때 사용했던 goormide를 사용해 컨테이너를 만들어 사용할 수도 있다. 


설치 완료 후 ubuntu server 버전을 다운받는다. 

https://ubuntu.com/download/server

총 3가지 옵션이 존재한다. 
1. Multipass 
    자세히 공부가 필요하다. 설치해서 사용 해봤을 때, 
    윈도우 cmd, power shell으로 가상 하드의 분리 없이 사용할 수 있도록 되어 있는 것 같다. 

2. Maas

3. Manual install 
    직접적으로 사용할 파일이다. 
    20.04.1 LTS 버전을 다운 받아서 사용한다. 
    iso 파일로 가상 하드에 설치할 os 파일이다.

VirtualBox를 실행하여 새로 만들기를 통해 
가상 머신을 나타내는 이름과 저장할 폴더, 설치 운영체제 및 
할당할 메모리와, 가상하드의 용량을 선택하여 생성한다. 

생성된 가상머신을 실행시, 광학 드라이브를 다운 받은 ubuntu server의 iso 파일을 선택하여 실행 후 
설정을 완료하면 설치가 마무리 된다. 

![virtualbox](https://user-images.githubusercontent.com/65690925/99487467-c5392300-29a9-11eb-8c8a-08dbc34f3034.JPG)

### 추가

내부 IP를 할당 받기 위한 네트워크 설정 

실행된 가상 머신을 종료한 후

virtual box에 새로 만들기 옆으로 설정을 클릭한다. 

새로 뜬 창에서 왼쪽 메뉴에 네트워크를 클릭해,
 어뎁터 1 을 어뎁터에 브리지 변경한다.
 어뎁터 2 를 NAT으로 변경한다.

변경 후 내부 IP가 할당된다. 

## 2. Apache INSTALL
1에서 설치한 가상 리눅스를 실행한다.
설치시 설정한 아이디와 비밀 번호를 사용하여 접속한다.

![linux server_enter](https://user-images.githubusercontent.com/65690925/99487693-47c1e280-29aa-11eb-940c-35677d0827a1.JPG)

설치에 앞서 업데이트를 수행한다. 
sudo apt-get update && sudo apt-get upgrade

아파치2를 설치한다. 
sudo apt-get install apache2 

설치 후 버전확인으로 설치가 잘되었는지 확인하고,
서비스를 시작한다. 

apache2 -v 
sudo service apache2 start


start, stop, restart 등 명령어 존재한다.

실행 후에 아무런 변화가 없는 것처럼 보여서 실망할 수 있지만, 
서버가 돌아가는지 절차를 통해서 확인하자.

1. 서비스가 내부적으로 돌아가는 지 확인 
    
    sudo apt-get install net-tools
    netstat -ntlp

    local Address에 :::80 이 보인다면 서비스가 돌고있는 것을 알 수 있다. 

2. 돌아가고 있는 웹 서버로 접속하여 확인

    1에서 네트워크 설정을 완료 했다면, 
    ifconfig를 통해 내부 아이피 값을 확인할 수 있다.
    
    웹사이트에 아이피 값을 친다면 아파치 파일 사이트를 확인할 수 있다. 


![linux netstat](https://user-images.githubusercontent.com/65690925/99487703-4b556980-29aa-11eb-8a25-99bdf5076feb.JPG)
![apache 실행](https://user-images.githubusercontent.com/65690925/99488074-f82fe680-29aa-11eb-8479-4888e607fb5e.JPG)

### 추가 
1. 방화벽 설정
    ufw를 사용한다. 

    #### what is ufw ? 

    sudo ufw app info "Apache Full"
    sudo ufw allow in "apache Full"
    sudo ufw status numbered

2. 포트 변경 

    sudo nano /etc/apache2/port.conf >> 80 -> 7010
    sudo nano /etc/apache2/sites-available/000-default.conf >> 80 -> 7010

    sudo ufw allow 7010 // 방화벽 통과 설정 

3. 한글 깨짐 수정 

    sudo nano /etc/apache2/conf-enabled/charset.conf

    #AddDefaultCharset UTF-8 > 의 주석제거후 저장


각 설정 후에 아파치를 재 실행하여 서버에 설정된 파일을 변경한다. 

sudo service apache2 restart

## 3. mysql 설치 



## 4. php 설치 


## 5. myphpadmin 설치 및 설정 
