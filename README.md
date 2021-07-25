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
public class Market {
	@Autowired
	private Fruit fruit;

	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}

@Component
public class Fruit {
	private String name;
	private int price = 10;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

@Controller
public class HomeController {
	
	@Autowired
	private Market market;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("market", market);
		return "home";
	}
}
```
## 4. JUnit
*  자바용 단위 테스트 API
*  단위 테스트: 하나의 기능이 올바르게 동작하는지 독립적으로 테스트하는 것

### JUnit 관련 어노테이션들
*  @Test: 이 어노테이션이 붙어있는 메서드를 단위 테스트로 인식하고 실행한다
*  @Ignore: 이 어노테이션을 붙인 테스트 메서드를 무시한다.
*  @Test(expectied=): 원하는 예외가 발생해야 통과하는 테스트
*  @Test(timeout=): 시간 제한 안에 성공해야 하는 테스트

## 5. Spring Test 관련 어노테이션들
*  @RunWith(SpringJUint4ClassRunner.class): 테스트를 스프링 테스트로 실행하기 위한 설정
*  @ContextConfiguration(컨텐스트 경로): 원하는 Context를 로드하여 테스트를 진행할 수 있다
-Context에 실려있는 Bean들을 테스트하기 위한 옵션이다

### 테스트를 하기 위한 세팅
1. MVN 레포지토리 홈페이지에 들어가 원하는 JAR가 있으면 메이븐 코드를 복사해서 POM.xml에 들어가서 Spring에 들어가서 해당 코드를 붙이기
![image](https://user-images.githubusercontent.com/82793713/126891397-0f9089c8-3252-41de-8b69-0c7183f357cf.png)
2. 프로젝트 우클릭-메이븐-메이븐 업데이트를 하면 원하는 JAR가 들어가 있음
3. 테스트 하려는 클래스 위에 @RunWith(SpringJUnit4ClassRunner.class)와
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")를 불러와줘야함
```C
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class QuizTest {
	
	@Autowired
	Prime prime;
	
	@Test
	public void check1() {
		assertFalse("1이 소수가 아니라고 나와야 함",prime.isPrime(1));
	}
	
	@Test
	public void check3() {
		assertTrue( "3이 소수인지 테스트", prime.isPrime(3));
	}
}
```
