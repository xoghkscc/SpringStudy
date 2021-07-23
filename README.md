# SpringStudy
## 0. 작업환경 세팅
1.  https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3로 이동
2.  자신의 이클립스 버전에 맞는 p2 레포지토리를 복사해서 이클립스 install new software를 통해 설치
3.  Open Perspective에 가서 Spring 버전으로 전환
4.  Spring Legacy Project에서 Spring MVC Project를 만들면 됨
## 1. 프레임워크
* 프로젝트 개발에 필요한 전체적인 구조를 이미 만들어 놓은 것
* 개발자는 이미 완성된 프로젝트 구조에 빈칸만 채우는 형식으로 개발을 진행하게 된다
* 어느정도 수준의 품질이 항상 보장된다는 장점이 있다
* 개발 시간도 많이 단축된다
## 2. 스프링 프레임워크
* 자바를 활용해 웹 개발을 진행하기 위한 프레임워크
* 자바의 다양한 디자인 패턴들이 이미 적용되어 있다
### 스프링의 주요 특징
* POJO(Plain Old Java Object)
    * JSP처럼 새로운 문법을 사용해야하는 JAVA의 사용을 지양
    * 백엔드에 JSP를 이용하지 않고 순수 JAVA를 활용하려고 노력
*  의존성 주입(DI, Dependeny Injection)
    * 생성자를 사용하지 않아도 알아서 인스턴스를 생성해 코드를 마저 완성해준다.
    * new를 사용하는 코드를 금기시 한다(Apple apple = new Apple()와 같은 인스턴스 선언 방식을 금기)
```C
*Bus.java

class Bus{
Tire[] tires = new Tire[4]
}
//즉 버스라는 클래스가 있기 위해서는 타이어라는 클래스가 있어야 함
//따라서 버스는 타이어에게 의존하고 있음
```
### 스프링 프로젝트 기본 구조
* src/main/java: 자바 메인 코드를 작성하는 곳
* src/main/resources: 자바 메인 코드를 실행할 때 필요한 자원들의 경로
* src/test/java: 자바 테스트 코드를 작성하는 곳
* /WEB-INF/spring/root-context.xml: 이곳에 등록하는 것은 스프링 프로젝트 전체에서 접근할 수 있는 것이 된다
* /WEB-INF/spring/appServlet/servlet-context.xml: DispatcherServlet에서만 가져가 사용하는 설정 파일->DispatcherServlet의 설정을 정의할 수 있다.
* /WEB-INF/views: 컨트롤러에서 처리한 후 포워딩 될 뷰 페이지들을 모아놓는 곳
* pom.xml: 메이븐이 사용하는 xml. 이곳에 적혀았는대로 프로젝트를 관리해준다
## 3. 의존성 주입
* @Component: 스프링에서 관리해야하는 대상이 된다. 
컴포넌트 스캔을 통해 스프링의 컴포넌트로 등록된다.
* @Autowired: 이 어노테이션이 붙어있는 곳에 자동으로 의존성을 주입한다.
등록된 컴포넌트들 중에서 가장 적합한 컴포넌트를 선택하여 주입한다.
* <context:component-scan base-package=””>: roo-context 또는 servlet-context에서 사용할 컴포넌트를 스캔한다
base-package 어트립뷰트에 스캔할 패키지 경로를 적는다
```C
<context:component-scan base-package="com.kgitbank.*" />
//이런식으로 스캔할 패키지 경로 전체를 *로 해줘도 됨
```
* 스프링에서 관리되는 객체를 ‘빈(Bean)”이라고 부르고, 빈은 xml을 통해 등록한다
### 즉 넘겨주고 싶은 것은 @Componet를 달고 달아놓은 컴포넌트를 가지고 오고 싶을 때는 @Autowired를 쓰면 됨
```C

@Component
public class Market{

}
```

      
      
