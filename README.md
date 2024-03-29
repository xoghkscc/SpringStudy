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
### MVC(모벨-뷰-컨트롤러)
* 사용자 인터페이스, 데이터 및 논리 제어를 구현하는데 널리 사용되는 소프트웨어 디자인 패턴
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
//servlet-context.xml 혹은 root-context.xml에 작성되는 코드
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
## 6. Junit 테스트 방식
* assertEquals(a, b): a와 b의 값이 같은 값이면 테스트 통과
* assertSame(a, b): a와 b가 같은 인스턴스일 때 테스트 통과
* assertTrue(a): a의 실행 결과가 true일 때 테스트 통과
* assertFalse(a): a의 실행 결과가 false일 때 테스트 통과
* assertNotNull(a): a의 실행 결과가 null이 아니면 테스트 통과
* fail(msg): 이 메서드를 만나면 무조건 실패
## 7. Lombok
### Lombok을 사용하기 위한 세팅
1.  구글에 Lombok을 검색 후 다운
2.  jar파일을 실행 후 Specify location을 눌러 eclipse.exe가 있는 경로를 찾아가 eclipse.exe을 클릭 후 설치
이때 이클립스.exe까지의 경로 중 한글 경로를 피해야 함
3.  mavan 레포지토리에 가서 project lombok을 검색하여 다운 받은 롬북 버전을 찾아 그 메이븐을 pom.xml에 추가
4.  메이븐 업데이트

### Lombok
* 어노테이션만 붙이면 자바빈 스타일의 객체로 완성해주는 라이브러리
### 사용하는 어노테이션
* @Getter: 모든 필드에 Getter를 자동으로 생성
* @Setter: 모든 필드에 Setter를 자동으로 생성
* @NonNull: 해당 필드는 반드시 값이 있어야 함을 표시해줌
* @ToString: 모든 필드값을 출력하는 toString()을 알아서 오버라이드
* @EqualsAnsHashCode: equals와 hashCode를 알아서 생성
* @Data: 클래스 내부의 모든 필드에 대해 Getter/Setter를 생성, toString, equals, hashCode 오버라이드, 생성자도 자동으로 생성
* @Log4j: Log4j 연결을 자동으로 생성
* @NoArgsConstructor: 기본 생성자를 자동으로 생성
* @RequiredArgsConstructor: @NotNull이 붙은 필드만 채우는 생성자 생성
* @AllArgsConstructor: 모든 필드값을 채우는 생성자 자동으로 생성
```C
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	@NonNull
	private int employee_id;
	private String first_name;
	@NonNull
	private String last_name;
	@NonNull
	private String email;
	private int department_id;
}
//모든 필드에 대해 Getter, Setter가 생성
//기본 생성자가 생성되며 employee_id, last_name, email를 채우는 생성자 생성
//toString을 자동 오버라이드
```
## 8. POM(Project Object Model)
* 프로젝트 객체 모델
* Maven은 프로젝트를 항상 pom.xml에 적혀 있는대로 유지해주는 프로그램
* pom.xml에는 프로젝트의 모든 설정과 의존성에 대한 정보들을 담고 있다.
### pom.xml의 태그 정보
* name: 프로젝트 이름
* artifactId: 프로젝트의 아티팩트 ID
* groupId: 프로젝트의 그룹 ID
* version: 버전 설정
* packaging: 배포할 파일의 타입을 설정
* dependencise: 이 프로젝트에서 의존하는 다른 프로젝트들을 적는 곳
* dependency: 의존하는 프로젝트의 POM 정보를 적는 곳, 의존하는 프로젝트의 groupId, artifactId, version 그리고 프로젝트에 적용될 범위를 설정한다.
### scope
* 해당 dependency가 프로젝트에서 영향을 미치는 범위를 설정한다.
* complie: 컴파일 할 때 필요한 의존성(기본값)
    * 우리가 만든 소스를 해석하기 위해, 배포에도 포함된다(spring-context)
* runtime: 런타임에 필요한 의존성
    * 실행될 때 필요한 것, 배포에도 포함된다(ojdbc.jar, sl4j 등)
* provided: 컴파일 할 때는 필요하지만 런타임때에는 기본적으로 제공되는 모듈
    * 컴파일 할때는 필요하지만 배포할 때는 필요가 없는 것(jstl, jsp 등)
* test: 테스트 코드 컴파일 진행시에만 필요한 의존성, 배포에는 포함되지 않는다.
## 9. Log4j
 *  자바에서 로그를 호율적으로 남기기 위한 라이브러리
 *  디버그, 로깅등의 용도로 사용된다(이전에는 sysout으로 찍어봤음)
 *  Logger: 로그 메시지를 Appender에게 전달한다
 *  Appender: 자기가 맡은 위치에 전달받은 로그를 추가한다
 *  Layout: 로그를 어떤 형식으로 기록할지 설정한다
### Logging level
* OFF: 로그를 끔
* FATAL: 치명적인 에러
* ERROR: 에러
* WARN: 주의
* INFO: 일반 정보
* DEBUG: 디버깅 정보
* TRACE: 더 자세한 디버깅 정보
* ALL: 모든 로그를 보여줌
#### 로거에 로깅 레벨을 설정하며 설정한 레벨 이상으로 중요한 로그들만 수집하게 된다
```C
<logger name="com.kgitbank.model">
  <level value="error"/>
</logger>
//이를 통해 로그 레벨을 설정할 수 있다.

class LombokTest{
  Logger log = Logger.getLogger(this.getClass());
  @Test
  public void test(){
    Employee emp = new Employee(10, "Smith", "Allen");
    log.info(emp);
  }
}

```
### FileAppender
```C
	<appender name="file_appender" class="org.apache.log4j.FileAppender">
		<param name="file" value="./note/log/test_log.html" />
		<layout class="org.apache.log4j.HTMLLayout">
		</layout>
	</appender>
  
  <logger name="com.kgitbank.model">
		<level value="error" />
		<appender-ref ref="file_appender" />
	</logger>
//log/test_log.html에 로그가 기록된다.
```
### @Log4j
* 롬북에서 @Log4j를 어노테이션해서 사용해도 됨
```C
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RockPaperScossorsTest {
	
	@Autowired
	private RockPaperScissors rps;//root-context.xml에 빈을 등록
	
	@Test
	public void test() {
		for(int i = 0; i<20; i++) {
			log.error(rps.game());//@Log4j 어노테이션을 사용하였기에 log를 사용 가능
      //가위 바위 보 결과를 리턴해주는 rps.game() 메서드
		}
	}
} 
```
### PatternLayout
#### 로그 출력의 형태를 정해줄 수 있음
* %p: debug, info, warn 등 priority가 출력
* %m: 로그 내용
* %d: 로깅 이벤트 발생 시간
* %t: 로그 이벤트가 발생된 쓰레드의 이름
* %n: 개행 문자 출력
* %r: 응답 시간 출력
* %c: 카테고리 이름 출력
* %C: 로그를 생성한 클래스명
* %F: 로그가 발생한 파일명
```C
<appender name="patternLayout" class="org.apache.log4j.FileAppender">
		<param name="file" value="./note/log/RockPaperScissorsPattern.log" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="로그 발생 시각: %d{yyyy-mm-dd HH:mm:ss}, 에러 종류: %p, 카테고리: [%c] 로그내용: %m %n"/>
		</layout>
</appender>
```
### RollingFileAppender
#### 일정한 용량이 초과될 경우에 파일을 추가하여 로그에 기록
* MaxFileSize: 파일의 용량이 정해진 용량보다 넘어가면 새로운 파일을 만듬
* MaxBackupIndex: 백업할 파일의 개수를 정함
```C
<appender name="Rolling" class="org.apache.log4j.RollingFileAppender">
		<param name="MaxFileSize" value="50KB"/>
		<param name="MaxBackupIndex" value="20"/>
		<param name="file" value="./note/log/RockPaperScissorsRolling.log"/>
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="로그 발생 시각: %d{yyyy-mm-dd HH:mm:ss}, 에러 종류: %p, 카테고리: [%c] 로그내용: %m %n"/>
		</layout>
</appender>
```
### DailyRollingFileAppender
#### 매일 새로운 파일에 로그를 기록하는 FileAppender
* DatePattern: 시간이 지나면 이전 날짜꺼는 파일 형식 뒤에 날짜가 붙여짐
```C
<appender name="DailyRolling" class="org.apache.log4j.DailyRollingFileAppender">
		<param name="DatePattern" value="'.'yyyy-MM-dd"/>
		<param name="file" value="./note/log/RockPaperScissorsDailyRolling.log"/>
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="로그 발생 시각: %d{yyyy-mm-dd HH:mm:ss}, 에러 종류: %p, 카테고리: [%c] 로그내용: %m %n"/>
		</layout>
</appender>
```
## 10. MVC
### 스프링 MVC의 구조
* 프로젝트 구동시 xml을 활용하여 편리하게 다양한 설정들을 하도록 미리 설계되어있다.
* 프로젝트 설정에 관여하는 xml은 web.xml, root-context.xml, servlet.context.xml이다
* context-param: 모든 컨테이너에서 함께 사용하는 초기화 파라미터
* root-context.xml의 경로는 web.xml에 전역 초기화 파라미터 (context-param)으로 등록되어 있다.
* servlet-context.xml의 경로는 appServlet의 초기화 파라미터(init-param)로 등록되어 있다
### 스프링 MVC에서 사용자의 요청이 처리되는 순서
1.  HttpRequest가 DispatcherServlet에 도착한다
2.  요청 내부의 URL을 통해 컨텍스트에 등록된 컨트롤러 중 가장 알맞은 컨트롤러를 찾는다
3.  해당 컨트롤러를 모두 실행한 후 값을 리턴 받는데, 리턴 받는 타입에 따라 뷰를 찾는 방식이 달라진다
      * 리턴 받는 타입: String, Model, ModelAndView… 등
4.  컨트롤러의 실행 결과가 ViewResolver 클래스가 해석하여 어떤 웹 페이지를 응답할지 결정한다
## 11. Controller
* JSP의 복잡했던 절차들을 많이 생략한 방식으로 웹 서버를 구현할 수 있음
      * 포워드, 파라미터 꺼내기 등
* 다양한 방식의 매개변수와 리턴 타입을 사용할 수 있음
* GET/POST등 method별로 별도의 처리도 어노테이션으로 손쉽게 처리 가능
* 클래스 위에 @Controller 어노테이션을 달아놓으면 스프링이 알아서 수집해감
### @RequestMapping
* 사용자의 요청 URL과 해당 컨트롤러를 매핑시키는 어노테이션
* 클래스 위에도 사용할 수 있고 메서드 위에도 사용할 수 있다.
* value: 매핑할 URL을 설정한다(String 배열)
* ethod: 요청 방식을 구분할 수 있다.
* @GetMappling, @PostMapping 등으로 간편화 할 수도 있다
### 컨트롤러의 파라미터 자동 수집 기능
* 컨트롤러의 매개변수 이름만 같아도 데이터가 알아서 매개변수로 전달된다
* 넘어오는 데이터와 알맞은 형태의 자바빈 클래스를 사용한다면 JSP의 request.getParameter를 할 필요가 없어진다
* parameter는 String 타입이나 모델에 적용할 때 알아서 변수에 맞춰 넣어줌
* @RequestParam(“number”) int myNumber
      * 이런 식이면 파라미터의 이름을 일치 안하고 myNumber로 입력하여도 number로 들어가게 바꿔줄 수 있음(웬만하면 맞추자)
* 체크박스처럼 여러 개를 받고 싶으면 @RequestParam(“이름”) ArrayList  이런걸로 받아도 됨
### Model 타입 파라미터
* Spring에서는 각 영역 대신 Model에 어트리뷰트를 실어서 전달한다
* 컨트롤러의 매개변수에 Model타입 변수를 설정해놓으면 알아서 Model인스턴스가 넘어오게 된다
* 자바빈 클래스를 사용한 파라미터는 자도응로 모델 어트리뷰트에 실려 뷰까지 전달된다
* 기본 타입 파라미터는 자동으로 전달되지는 않지만 @ModelAttribute 어노테이션을 사용해 자동으로 전달할 수 있다
```C
@Log4j
@Controller
@RequestMapping("/hello/")
public class HelloController {
	
	//practice/hello/minsu or 민수 일때 작동함
	@RequestMapping(value = {"/minsu", "/민수"}, 
			method = {RequestMethod.GET, RequestMethod.POST} ) 
	public String minsu() {
		log.info("minsu controller에 도착");
		return "hello/minsu";//view/hello/minsu.jsp로 보내는 걸 의미
	}
	
	//practice/hello/chulsu 일때 작동함
	@GetMapping("/chulsu")
	public void getChulsu(Human human,@RequestParam("taset") ArrayList<String> taset) {
		log.info("name: "+ human.getName());
		log.info("age: "+ human.getAge());
		log.info(taset);
//  Spring에서는 이렇게 해도 파라미터가 받아짐
	}
//	@GetMapping("/chulsu")
//	public void getChulsu(HttpServletRequest request) {
//		log.info("get chulsu controller에 도착");
//		log.info("name: "+ request.getParameter("name"));
//		원래는 이렇게 request를 전달받아 이렇게 써야 하는게 옛날 방식
//	}
	
	@RequestMapping("/choosinsu")
	public String choo(Model model, Human human) {
		return "hello/choosinsu";
	}
	
	@GetMapping("/kim")
	public String kim() {
		//앞에 redirect:을 붙이면 뷰를 찾지 않고 리다이렉트를 응답
		return "redirect:/hello/choosinsu?name=김&age=321";
	}
}
```
### 컨트롤러의 리턴 타입
1.  뷰를 찾는 타입
* DispatcherServlet은 컨트롤러의 리턴값을 통해 알맞은 뷰를 찾게끔 만들어져있다.
* void: 요청 URI로 /WEB-INF/views/에서 동일한 경로상의 view를 찾는다
* String: 리턴한 문자열 경로로 /WEB-INF/views/에서 view를 찾는다
* 문자열 리턴값 앞에 redirect:을 붙이면 리다이렉트한다(forward는 기본값-생략가능)
* ModelAndView: 데이터도 실어놓을 수 있고 다음으로 가야하는 view가 어딘지도 담고 있다.
2.  뷰를 응답하지 않고 웹 페이지 이외의 것을 응답하는 타입
* 자바빈 객체 타입: 요청한 사용자에게 데이터를 생성하여 전달한다 (주로 JSON타입)
* Model 타입: 요청한 사용자에게 모델에 들어 있는 데이터를 응답한다
* ResponseEntity: 직접 원하는 타입의 응답을 생성할 수 있는 클래스
## 12. HikariCp
### pom.xml에 다음과 같이 메이븐을 등록
```C
	<dependency>
		<groupId>com.zaxxer</groupId>
		<artifactId>HikariCP</artifactId>
		<version>4.0.3</version>
	</dependency>
```
### root-context에 다음과 같은 방식으로 등록(HikariCp Github를 참조)
```C
	<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521/XEPDB1"></property>
		<property name="username" value="java1"></property>
		<property name="password" value="1234"></property>
	</bean>

	<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
		<!-- 생성자로 만드는거임 -->
		<constructor-arg ref="hikariConfig" />
	</bean>
```
## 13. Mybatis
### pom.xml에 다음과 같이 메이븐을 등록
```C

	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis</artifactId>
		<version>3.4.6</version>
	</dependency>
	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis-spring</artifactId>
		<version>1.3.3</version>
	</dependency>
```
### root-context에 다음과 같은 방식으로 등록(mybatis 공식 페이지를 참조)
```C
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<!--이때 이 dataSource는 Hikari에서 생성된 dataSource이다.-->
	</bean>
	
	<mybatis-spring:scan base-package="com.kgitbank.mapper" />
```
### 사용된 다른 프로젝트(참고)
* Lombok
* HikariCP
* Log4j
* Log4jdbc
* Spring
* Spring-jdbc
* Mybatis
* Mybatis-spring

### Mybatis란
* 	SQL문만 적으면 DB와 연결하는 코드(영속 계층)를 쉽게 작성하도록 도와주는 프레임워크
* 	거의 모든 JDBC 코드를 알아서 생성해서 사용해준다.
* 	사용자는 쿼리문의 종류와 원하는 SQL만 작성하면 된다.
* 	XML 또는 어노테이션 방식으로 설정할 수 있다.
* 	Mapper 인터페이스를 생성한 뒤 해당 인터페이스와 같은 경로에 있는 XML을 통해 해당 인터페이스의 실체를 구현할 수 있다.

### XML 방식으로 Mybatis를 활용하는 방법
1.  mapper패키지 경로와 똑같은 폴더 경로를 resourcer에 만들어준다
![image](https://user-images.githubusercontent.com/82793713/128635852-1b214dda-d553-4f1e-9502-2ad9ccb42693.png)
2.  그 폴더에 xml 파일을 만들고 https://mybatis.org/mybatis-3/ko/getting-started.html에 들어가서 매핑된 sql 구문을 복사해서 붙인다.
3.  mapper가 있는 경로에 대해서 mapper를 작성
```C
<mapper namespace="com.kgitbank.mapper.EmployeeMapper">
```
### 예시
* xml파일(src/main/resources/com/kgitbank/grade/mapper/GradeMapper.xml)
```C
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  <mapper namespace="com.kgitbank.grade.mapper.GradeMapper">
    <insert id="insertGrade">
      INSERT into grade VALUES (grade_seq.nextval, #{student_name}, #{grade})
    </insert>
 </mapper>
```
* mapper.java(src/main/java/com.kgitbank.grade.mapper.GradeMapper.java)
```C
public interface GradeMapper {
	public int insertGrade(Grade g);
 //Grade은 student_id, student_name, grade를 필드로 가지로 있는 모델이다.
 }
```
* Controller.java(src/main/java/com.kgitbank.grade.controller.RestController.java)
```C
@RestController
@Log4j
@RequestMapping("/crud_rest")
public class CrudRestController {
	@Autowired
	GradeMapper gm;
	
	@PostMapping(value = "/insertGrade")
	public void insertGrade(@RequestBody Grade grade) {
		gm.insertGrade(grade);
	}
}
```
## 14. Web Project Tier(웹 프로젝트 계층)
* 화면 계층(Presentation Tier)
    * 화면에 보여주는 코드를 작성하는 계층(JSP)
* #비즈니스 계층(Business Tier)
    * 고객이 원하는 요구사항을 구현하는 코드들(xxxService라는 이름으로 표시한 서비스 컴포넌트 구현)
* #영속 계층(데이터 계층, Persistence Tier)
    * Mybatis를 통해 생성되는 DB 접근 코드들

### 웹 프로젝트 계층 구조에 따른 클래스 이름 규칙
* 컨트롤러 클래스: xxxController
* 비즈니스 로직 클래스: xxxService(인터페이스), xxxServiceImpl(인터페이스 구현체)
* 데이터 접근 클래스: xxxDAO, xxxRepository, xxxMapper(DB와의 통신을 담당하는 코드)
* 데이터 클래스(모델): xxxVO, xxxDTO

### 패키지 이름 규칙
* 프로젝트 규모가 작은 경우
    * com.mycompany.projectname.controller.UserController
* 프로젝트 규모가 큰 경우
    * 우선 비즈니스 단위별로 패키지를 구분한 뒤 다시 내부에서 컨트롤러와 서비스를 구분한다
    * com.mycompany.projectname.membermange.controller.UserController
    * com.mycompany.projectname.adminboard.controller.AdminBoardController

### Controller는 주로 데이터를 어트리뷰트에 싣고 다른 view로 이동해주는 역할만 하는 것이 좋다.

## 15. Spring Bean Scope
* 스프링은 모든 Bean을 싱글톤으로 관리한다.
* 컴포넌트에 등록하여 사용할 객체에 인스턴스 값을 넣더라도 static처럼 동작한다.
* 스프링을 통해 개발할 때는 주입받은 객체는(@Autowired로 받음) 언제나 동일한 객체라고 가정하며 개발해야 한다.
* 따로 Bean의 Scope를 변경한다면 싱글톤에서 벗어날 수도 있다.
* sigleton:하나의 spring-context에 단 하나의 인스턴스만 존재하게 된다.
* prototype: 하나의 Bean으로 여러 인스턴스가 생성될 수 있다.
* request: 하나의 요청(HttpRequest)에 대해 하나의 인스턴스가 존재하게 된다.
* session: 하나의 HttpSession에 대해 하나의 인스턴스가 존재하게 된다.

### 추가한 외부 프로젝트
* jackson-datanind
* jackson-dataformat-xml
* gson

## 16. REST(Representational State Tranfer)
* 하나의 URI가 하나의 고유한 리소스를 응답하도록 설계하는 개념
* 웹 서버가 웹 브라우저 뿐 아니라 다른 어플리케이션들과도 연결될 수 있는 방식
* GET/POST/PUT/DELETE/..등의 Http Method를 적극 활용한다.

### Spring의 주요 REST 어노테이션
* @RestController: REST방식 Controller임을 명시
* @ResponseBody: 일반적인 뷰 응답이 아닌 데이터 응답을 생성
* @RequestBody: JSON 데이터를 원하는 타입으로 바인딩 처리
* @PathVariable: URI에 들어있는 값을 파라미터로 추출할 때 사용

### @RestController
* 일반적인 컨트롤러와 다르게 동작한다.
* 메서드의 리턴 타입으로 사용자가 정의한 클래스 타입(데이터 모델)을 사용할 수 있다
* 리턴 타입으로 설정된 모델을 JSON 또는 XML로 변환하여 응답한다
```C
@RestController
@Log4j
@RequestMapping("/sample")
public class RestSampleController {
	
	@GetMapping(value = "/getstr", produces = "MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")//charset=UTF-8을 붙이면 한글을 쓸 수 있음.
	public FruitVO getFruitVO() {
		return new FruitVO();
	}
}
```
![image](https://user-images.githubusercontent.com/82793713/128636623-b6f2aa28-8dc4-4f90-a45a-c23d9d32251f.png)
-->JSON 형태로 응답함

### @PathVariable
#### @PathVariable란 URL 경로에 변수를 넣어주는 것
#### Maplling 어노테이션 값으로 {템플릿변수}를 사용
#### PathVariable어노테이션을 이용해 {템플릿변수}와 동일한 이름을 갖는 파라미터를 추가
```C
@GetMapping(value = "/path/{year}/{month}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String pathTest(
		@PathVariable("year") Integer year,
		@PathVariable("month") Integer month
	) {
		return "Hello! you putted"+year+"/"+month+" in your uri path";
	}
```
![image](https://user-images.githubusercontent.com/82793713/128636730-841f1dc1-2849-4948-8c95-7188c81d422e.png)
-->파라미터에 받은 값을 돌려줌

### @RequestBody
#### 컨트롤러에서 JSON 데이터를 받아야 할 때 사용하는 어노테이션
```C
@PostMapping(value = "/fruit", produces = "text/plain; charset=UTF-8")
	public String convertJsonFruit(@RequestBody FruitVO fruit) {
		return "Your fuits is " + fruit;
}
```
## 17. MockMvc Class
* 스프링이 제공하는 컨트롤러 단위 테스트용 클래스
* 가상의 mVC 컨트롤러를 생성하여 테스트 해볼 수 있다.
* mockMVC: 테스트를 진행하기 위해 생성한 Spring MVC Context
* perform(RequestBuilder): 생성한 mockMvc에 요청을 보내보는 메서드
* RequestBuilders: 원하는 메서드의 RequestBuilder를 생성한 팩토리 클래스
* andReturn(): perform()의 결과에서 리턴값을 꺼낸다 해당 컨트롤러 실행 결과에서 원하는 값들에 접근할 수 있다.

## 18. AJAX(Async JavaScript and XML)
* 웹 페이지 전체를 다시 로딩하지 않고, 웹 페이지의 일부분만 갱신하는 자바스크립트 문법
* 웹 페이지 백그라운드 영역에서 서버와 통신하여 데이터를 받아온 후 그 데이터를 활용한다.
* 원래는 XML을 받아오는 용도로 개발되었지만 최근에선 JSON을 더 많이 사용한다.

### JavaScript XMLHttpRequest
* 서버로 비동기 요청을 보낼 수 있는 비동기 요청 클래스
* 요청을 보낸 후 서버의 처리 상황에 따라 readyState가 변한다
* 서버에서 응답해준 상태 코드를 활용할 수 있다(Spring의 ResponseEntity_)
* GET방식으로 데이터를 보낼 때는 open() 메서드의 URI 뒤에 데이터를 붙여서 전송
* POST방식으로 데이터를 보낼 때는 send() 메서드의 매개변수로 데이터를 전송
```C
sampleAsyncBtn.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest();

	//	비동기 요청에 대한 상태가 변화할때마다 발생하는 이벤트
	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;

		if (status == 200 && readyState == 4) {
			//자바스크립트에서는 아주 쉽게 JSON 형식의 문자열을 Object로 변환할 수 있다
			myobj = JSON.parse(target.responseText);
      <!--traget에는 JSON형태로 모텔 FruitVO이 담겨있음(필드는 과일이름, 가격, 무게)-->
			
      Object.keys(myobj).forEach((key) => {
      <!--myobj는 JSON 형태로 결과값이 여러개이기 때문에 forEach로 값을 가져와 함-->
				const new_node = document.createElement("li");
				new_node.innerHTML = myobj[key];
				testList.appendChild(new_node);
			})
		}
	});
	//	비동기 요청에 method와 uri를 설정
	xhttp.open('GET', '/rest/sample/getSample', true);
	xhttp.send();
})
```
![image](https://user-images.githubusercontent.com/82793713/128637112-63ef714e-2eaf-49c5-ada5-d534cd29ce69.png)

## 18. 쿠키
* 서버가 클라이언트 쪽에 저장해 둘 수 있는 데이터
* 응답과 함께 실어보낼 수 있다.
* 클라이언트 측에서 위/변조가 자유롭기 때문에 보안에 주의해야 한다.
* 클라이언트 측에서 저장된 쿠키는 해당 클라이언트가 보내는 모든 요청에 포함된다.
    * 각 쿠키에 설정된 URL 범위에 따라 전달되지 않을 수도 있다.
* 쿠키로 데이터를 보내도 ${}로 똑같이 출력할 수 있음
```C
//쿠키 추가하기 1
@GetMapping("/check")
	public void check(
			@CookieValue(value = "id", defaultValue = "비회원") String id,
			@CookieValue(value = "login", defaultValue = "0") String login,
			Model model
	) {
		model.addAttribute("id", id);
		model.addAttribute("login", login);
}

//쿠키 추가하기 2
@GetMapping("/login")
	public String login(String id, String password, HttpServletResponse response) {
		response.addCookie(new Cookie("id", id));
		response.addCookie(new Cookie("password", password));
		return "cookie/login";
}
//쿠키 조회
	@GetMapping("read_all_cookie")
	public String readAllCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println("name: "+cookie.getName());
				System.out.println("value: "+cookie.getValue());
			}
		}
		return "/cookie/check";
	}
```
### 쿠키의 필드값들
* maxAge: 쿠키가 만료되는 시간(초단위)을 설정한다. 기본값은 -1이고, 브라우저 종료시 함께 삭제된다.
    * ex. 오늘 하루동안 팝업창 보지 않기 가능
* path: path에 설정해놓은 경로의 하위 경로에서 모두 적용되는 쿠키로 설정한다
* domain: domain에 설정해놓은 IP주소(도메인이름)에서 모두 적용되는 쿠키로 설정
* HttpOnly: 쿠키에 자바스크립트 문법을 적용하여 나쁜짓을 하는 것을 예방한다(기본값은 false임)
