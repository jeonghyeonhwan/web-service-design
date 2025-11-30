# Todo REST API (Spring Boot)

간단한 Todo 관리 기능을 제공하는 Spring Boot 기반의 REST API 프로젝트입니다.  
과제 요구사항인 **POST / GET / PUT / DELETE 각각 2개씩 총 8개의 API 구현**,  
**표준화된 응답 형식**, **미들웨어(로그 필터)** 를 모두 충족합니다.

---

## 📌 기술 스택

- Java 17+
- Spring Boot 3.5.6
- Spring Web
- Validation
- Lombok (선택)
- Gradle

---

## 📁 프로젝트 구조

com.example.web_service
│
├── WebServiceApplication.java # Spring Boot 실행 파일
│
├── db
│ └── ApiResponse.java # 표준 응답 형식 클래스
│
├── middleware
│ └── RequestLoggingFilter.java # 모든 요청 로그 출력 미들웨어
│
├── controller
│ └── TodoController.java # 8개의 REST API 제공
│
├── service
│ └── TodoService.java # 메모리 기반 Todo 저장/조회 로직
│
└── model
└── Todo.java # Todo 데이터 모델
