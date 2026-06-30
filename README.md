# 💰 한푼 (Hanpoon)

> Spring Boot 기반의 금융 계좌 관리 및 송금 시스템 백엔드 프로젝트

## 프로젝트 소개

한푼(Hanpoon)은 Spring Boot 기반의 금융 계좌 관리 및 송금 시스템 백엔드 프로젝트입니다.

회원가입 및 로그인, 계좌 관리, 입·출금, 계좌 간 송금, 거래내역 조회 등 금융 서비스의 핵심 기능을 구현하며, 백엔드 기술과 금융 도메인을 학습하고 적용합니다.

또한 Spring Security와 JWT를 활용한 인증 및 인가, JPA 기반 데이터베이스 설계, 트랜잭션을 활용한 송금 처리, 예외 처리, REST API 설계 등 실무에서 활용되는 백엔드 기술을 적용하여 안정적이고 확장이 편리한 금융 서비스를 구현합니다.

---

## 프로젝트 목표

* Spring Boot 기반 REST API 서버 개발
* JWT 기반 사용자 인증 및 권한 관리 구현
* 금융 도메인을 반영한 계좌 및 거래 시스템 설계
* 트랜잭션을 활용한 안전한 송금 기능 구현
* 관계형 데이터베이스 설계 및 JPA 활용
* RESTful API 설계 및 구현
* 공통 예외 처리 및 응답 구조 설계
* Swagger(OpenAPI)를 활용한 API 문서 자동화

---

## 주요 기능

### 사용자(User)

* 회원가입
* 로그인(JWT 인증)
* 계좌 개설
* 내 계좌 조회
* 입금
* 출금
* 계좌 간 송금
* 거래내역 조회
* 거래내역 검색 및 페이징

### 관리자(Admin)

* 회원 조회 및 관리
* 계좌 조회
* 거래내역 조회

---

## 기술 스택

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT

### Database

* MySQL

### Build Tool

* Gradle

### API Documentation

* Swagger (OpenAPI)

### Version Control

* GitHub

---

## 학습 및 구현 목표

* RESTful API 설계 원칙 이해 및 적용
* Spring Security 기반 인증 및 인가 구현
* JWT를 활용한 로그인 처리
* JPA를 활용한 객체 중심 데이터 접근
* 금융 업무 규칙을 반영한 비즈니스 로직 구현
* 트랜잭션을 활용한 데이터 정합성 보장
* Enum을 활용한 상태 관리
* 페이징 및 검색 기능 구현
* 계층형 아키텍처(Controller-Service-Repository) 적용
* 유지보수와 확장을 고려한 프로젝트 구조 설계

---

## 향후 확장 계획

* OAuth2 로그인(구글 / 네이버)
* 금융 Open API 연동
* 환율 조회 기능
* 금융상품 정보 조회
* Redis를 활용한 성능 개선
* AWS 배포
