# Domain 
~~~
A domain is a field of study that defines a set of common requirements, terminology, and functionality 
for any software program constructed to solve a problem in the area of computer programming, 
known as domain engineering.
컴퓨터 프로그래밍으로 문제를 해결하기 위해 만들 소프트웨어 프로그램을 위한 요구사항, 용어, 기능을 정의하는 학문 영역이 도메인 공학이다.
~~~
이 정의에 따르면, '도메인'은 해결하고자 하는 문제 영역 정도가 될 것 같다.

사실 도메인의 사전적 의미는 데이터, 영향이 미치는 범위, 영역이라고 정의 되어있는데요.

프로그래밍 입장에서 해결해야할 문제 영역, 비즈니스 영역 안에서 요구사항, 용어, 기능을 정의하게 때문에

도메인이 즉 해결해야할 문제 영역, 비즈니스라고 볼수 있을 것 같습니다.


## Domain Model

~~~
A domain model in problem solving and software engineering is a conceptual model of all the topics related to a specific problem. 
It describes the various entities, their attributes, roles, and relationships, 
plus the constraints that govern the problem domain. It does not describe solutions to the problem.
소프트웨어 공학에서 도메인 모델이란 특정 문제와 관련된 모든 주제의 개념 모델이다. 도메인 모델은 다양한 엔티티, 엔티티의 속성, 역할, 관계, 제약을 기술한다. 문제에 대한 솔루션을 기술하지 않는다.
~~~

특정 도메인, 문제영역을 개념적으로 표현한 것이다 
 

- 꼭 클래스 다이어그램의 형식으로 표현될 필요는 없지만 객체지향 프로그래밍을 하는 경우에는 일반적으로 클래스 다이어그램의 표기법을 사용해서 도메인 모델을 정리하는게 여러모로 유용합니다. 


- https://csdaniel.tistory.com/40

## ubiquitous 언어

보편적인(ubiquitous) 언어의 사용이다. 

도메인 전문가와 소프트웨어 개발자 간의 커뮤니케이션 문제를 없애고 상호가 이해할 수 있고 모든 문서와 코드에 이르기까지 동일한 표현과 단어로 구성된 단일화된 언어체계를 구축해나가는 과정을 말한다. 

이로서 분석 작업과 설계 그리고 구현에 이르기까지 통일된 방식으로 커뮤니케이션이 가능해진다.

## MSA

MSA란 마이크로 서비스 아키텍처(Micro Service Architecture)의 약자로 단일 프로그램을 각 컴포넌트 별로 나누어 작은 서비스의 조합으로 구축하는 방법입니다.


### Monolithic 

전통적인 개발 방식으로 모든 컴포넌트가 하나의 어플리케이션으로 동작한다. 

트랜잭션이 하나의 어플리케이션에서 처리하기 때문에 개발이 용이하다. 

하지만 볼륨이 커질수록 빌드 조차 어려워지고 컴포넌트끼리의 서로 영향을 끼쳐 개발이 점점 어려워진다.


- 빌드/테스트 시간이 길어집니다.

작은 수정에도 시스템 전체를 빌드해야 하며, 테스트 시간도 길어집니다. 요즘처럼 CI/CD가 강조되는 시점에서는 큰 문제가 될 수 있습니다.

- 선택적 확장이 불가능합니다.

이벤트로 인해 서비스 접속 량이 폭증할 경우 프로젝트 전체를 확장해야만 합니다.

- 하나의 서비스가 모든 서비스에 영향을 줍니다.

이벤트 서비스에 트래픽이 몰려 해당 서버가 죽게 된다면 다른 모든 서비스 역시 마비 되는 상황이 오게 됩니다.


### Saga

### CQRS

### Event Sourcing


### 오케스트레이션

오케스트라 지휘자처럼 서비스를 안내하고 처리하는 중앙 컴포넌트를 두는 방식이다.

장점 : 동작방식과 단계별 요청처리 상태를 확인하기 좋다.

단점 : 오케스트레이션 서비스에 지나치게 많은 역할이 부여된다. 자칫하면 미니 모놀리틱이 될 수도 있다.

### 코레오그래피

코레오그래피 = 안무가라는 뜻으로 

특정 음악에 맞추어 자신의 스타일로 안무를 만들듯이 

각각의 서비스는 변경사항을 이벤트로 발생시키고, 원하는 이벤트를 구독하고 필요할 때 작업을 처리하는 방식이다.

consumer를 특정하는 것이 아니고 비즈니스 객체에 대한 crud 이벤트만 발생시키기 때문에 

루즈 커플링이 된다. 단점으로 프로세스 동작과 단계별 상태를 파악하기 쉽지 않다.

또한 순환성 의존성이 생기기 쉬운 구조이다.

- https://happy-coding-day.tistory.com/entry/%EC%98%A4%EC%BC%80%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B4%EC%85%98orchestration%EA%B3%BC-%EC%BD%94%EB%A0%88%EC%98%A4%EA%B7%B8%EB%9E%98%ED%94%BC-choreography
- https://fors.tistory.com/587
- https://m.blog.naver.com/leety72/221739596027


## 기타 

### CUPID

https://blog.naver.com/gngh0101/222755144095

- Composable: plays well with others
- Unix philosophy: does one thing well
- Predictable: does what you expect
- Idiomatic: feels natural
- Domain-based: the solution domain models the problem domain in language and structure


## References
- https://javacan.tistory.com/entry/what-is-a-domain-model
- https://joont92.github.io/ddd/%EB%8F%84%EB%A9%94%EC%9D%B8-%EB%AA%A8%EB%8D%B8/
- https://medium.com/react-native-seoul/%EB%8F%84%EB%A9%94%EC%9D%B8-%EC%A3%BC%EB%8F%84-%EC%84%A4%EA%B3%84-domain-driven-design-in-real-project-bounded-context-e2bee96deeb2
- https://incheol-jung.gitbook.io/docs/q-and-a/architecture/ddd
- https://medium.com/myrealtrip-product/what-is-domain-driven-design-f6fd54051590