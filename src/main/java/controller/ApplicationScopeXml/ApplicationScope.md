# Application Scope

* 서버가 가동될 때 부터 서버가 종료되는 시점까지의 범위.  
  * 처음 요청이 발생하고 응답결과가 발생할 때 까지의 범위 : requestScope  
  * 브라우저에서 최초 요청이 발생하고 브라우저가 종료될 때 까지의 범위 : sessionScope


* Application Scope 동안 사용할 수 있는 메모리영역이 만들어지며  
  ServletContext 클래스 타입의 객체로 관리된다.  
  이 객체는 HttpServletRequest 객체로 추출이 가능하고,  
  Controller 에서 주입받을 수도 있다
  
    
* ServletContext 에 저장된 데이터, 객체는 서버가 종료되기 전까지   
  웹브라우저에 관계 없이 동일한 메모리 공간을 사용하게 된다.


* Bean 을 정의할 때 application scope 로 정의하면  
서버가 가동될 때 자동으로 Bean 이 주입된다.
  

* (중요) 주입된 Bean 은 application 영역에 저장되지 않는다.  
  1. 데이터를 저장하고 싶다면 Model 클래스를 이용하여 데이터를 담아서 requestScope 영역에서 찾거나, 
  2. 이전 applicationScope 예제에서 이용했던 HttpServletRequest 의 ServletContext 를 이용해야 한다.


* (중요) 서버가 가동될 때 자동주입되는 것이므로 @Lazy 를 이용하여  
Bean 의 주입을 지연시킬 필요는 없다.