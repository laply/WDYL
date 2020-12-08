
설치환경 ubuntu 20.04 

리눅스 서버에 sftp를 설정 하여 외부에서 쉽게 파일 업로드를 하기 위해서 사용합니다.

 리눅스 서버에 테스트를 하기 위해 git, github를 이용해서 파일을 업로드 하는 중,

용량에 대한 문제와 쉬운 업로드 하기위해서 ftp를 연결하는 방법을 찾았습니다.
 
 하지만 쉽게 설치되지 않았고 시행차고를 많이 겪었습니다.
같은 시행착오를 겪지 않기 위해 기록합니다.

윈도우에서는 filezilla 를 사용해서 업로드 및 사용 하도록 하겠습니다.

## ssh 설치 

vsftpd가 ssh 기반으로 사용 되므로, 우선적으로 ssh를 설치가 필요합니다. 


    sudo apt-get install ssh
    sudo nano /ect/ssh/sshd_config

설정파일에 들어가 두 곳을 수정합니다. 

    Port 22
    ...
    PermitRootLogin yes

수정 후 ssh를 시작 합니다.

    sudo service start

설치 완료

## vsftpd 설치 

ssh 만큼 sftp를 설치합니다.
    
    sudo apt-get install vsftpd 
    sudo nano /etc/vsftpd.conf

설정파일에 들어가 주석제거와 수정을 합니다. 

    listen=YES
    ...
    write_enable=YES

수정 후 vsfptd를 재시작 합니다.

sudo systemctl restart vsftpd 


## 방화벽 확인

    sudo ufw status 

22 번 포트가 열려 있는지 확인하고 열려있지 않다면

    sudo ufw allow 22/tcp 

열어줍니다. 


## 접속 확인 

접속할 윈도우로 돌아가 filezilla를 실행합니다. 

그 후 sftp 선택, 

ip / id / password 를 입력 후 연결해줍니다.


참고 
https://copycoding.tistory.com/206
https://copycoding.tistory.com/212