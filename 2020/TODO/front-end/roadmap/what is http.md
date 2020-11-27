front-end 2020 load map 두번 째


## HTTP (HyperText Transfer Protocol)

텍스트 기반의 통신 규약으로 
인터넷에서 데이터를 주고받을 수있는 프로토콜이다.

이러한 규약 때분에 모든 프로그램이 규약에 맞춰 개발하고 
서로 정보를 교환할 수 있다.

http 는 웹 에서 이루어지는 모든 데이터 교환의 기초이며, 
클라이언트 - 서버 프로토콜이다. 


## HTTP 특징

### 1. request - reponse 

HTTP는 클라이언트 - 서버 프로토콜이다.

클라이언트가 HTTP 요청을 서버에 보내면, 

서버는 요청을 처리한후 결과에 따른 HTTP 응답을
클라이언트에게 보내는 방식으로 수행된다. 

### 2. stateless 
    
stateless 란, 
server side에 client, server의 동작, 상태정보를 저장하지 않는 형태이다.
server응답이 client 와의 세션상태와 독립적이다.


통신을 서로 주고받아도 클라이언트와 서버가 서로 연결되어 있는 것이 아니라, 
각각의 통신은 독립적이다. 

### 3. URL (Uniform Resource Locators)

URL은 서버에 자원을 요청하기 위해 입력하는 영문 주소다. 
    
    ex) http://www.domain.com:8080/post?name=b&id=cc
    protocol://host:port/resorcePath?query


## 구성요소

클라이언트의 개별적인 요청들은 서버로 보내지며, 서버는 요청을 처리하고
response 라고 불리는 응답을 제공한다.

    // client-server-chain

이 요청과 응답 사이에는 여러 개체들이 있다. 
다양한 작업을 하는 게이트 웨이 또는 캐시 역활의 프록시 등이 있다. 


### 1. 웹서버
    
클라이언트에 의한 요청에 대한 문서를 제공하는 서버.


### 2. 프록시 

통신 계층중 애플리케아션 계층에서 동작하는 것들을 일반적으로 프록시라고 부른다.
프록시는 다양한 기능들을 수행 할 수 있따.

    - 캐싱
    - 필터링
    - 로드 밸런싱 
    - 인증
    - 로깅


## HTTP 흐름 

클라이언트가 서버와 통신 하고자 할 때, 최종서버가 됐든 
중간 프록시가 됐든, 다음 단계의 과정을 수행한다. 

1. TCP 연결을 연다.
    
연결은 요청을 보내거나 응답을 받는데 사용된다. 
새 연결이나, 기존의 연결이나 등등 여러가지 방법을 사용한다.

2. HTTP 메세지를 전송한다.

    GET / HTTP/1.1
    Host: developer.mozilla.org
    Accept-Language: fr

3. server가 전송한 응답을 읽는다.

    HTTP/1.1 200 OK
    Date: Sat, 09 Oct 2010 14:28:02 GMT
    Server: Apache
    Last-Modified: Tue, 01 Dec 2009 20:18:22 GMT
    ETag: "51142bc1-7449-479b075b2891b"
    Accept-Ranges: bytes
    Content-Length: 29769
    Content-Type: text/html

    <!DOCTYPE html... (here comes the 29769 bytes of the requested web page)

4. 연결을 닫거나 다른 요청을 위해 재사용 한다. 

HTTP 파이프라이닝이 활성화 되면 첫번째 응답을 완전히
 수신할 때 까지 기다리지 않고 여러 요청을 보낼 수 있다.

## HTTP 메세지 

### 1. 요청

### 2. 응답 

## HTTP 요청 메소드 
## HTTP 상태코드 


## HTTPS 

## HTTP/1 HTTP/2

참고 

https://ychae-leah.tistory.com/81
https://developer.mozilla.org/ko/docs/Web/HTTP/Overview
https://joshua1988.github.io/web-development/http-part1/