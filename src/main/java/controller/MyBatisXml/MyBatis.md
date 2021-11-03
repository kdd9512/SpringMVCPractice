# MyBatis

* JAVA 를 이용하여 DB와 연동하는 프로그램을 만드는 기술을 JDBC 라고  
하는데, MyBatis 는 JDBC 를 보다 쉽게 하기 위해 설계된 라이브러리이다.
  

* 추가해야 할 라이브러리 / Repository 목록.
    * DB 드라이버 jar  
      (이 예제의 경우 MariaDB)
    * spring jdbc
    * dbcp
    * mybatis
    * mybatis-spring
    * **MariaDB JDBC Repository (pom.xml 참고)** 
  

# 기본 세팅


1. DB 접속에 필요한 정보를 가지는 .properties 파일을 작성한다.  
보안상 url/id/비밀번호 를 노출하는건 좋지 않기 때문.

    
    ex) .properties 파일 내용 예시.
    db.drv = 드라이브
    db.url = url
    db.usr = 유저ID 
    db.pwd = 비밀번호


2. Mapper.xml 을 작성한다.  
이 파일 내에는 쿼리문이 들어간다.
   

    ex) Mapper.xml 작성 예시

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

    <mapper namespace="mapper 이름">
        <insert id="query 문 이름" parameterType="서버에서 받은 data 를 주입할 Bean 경로">
            <![CDATA[
            insert into MVC_test (data1, data2, data3)
            VALUES (#{data1},#{data2},#{data3})
            ]]>
        </insert>
        <select id="query 문 이름" resultType="서버에서 받은 data 를 주입할 Bean 경로">
            <![CDATA[
            select * from MVC_test
            ]]>
        </select>
    </mapper>


3. servlet_context.xml 내에 BasicDataSource 를 작성한다. 
   이 메서드는 접속 정보를 관리한다.  
   **(중요) .properties 파일을 읽어올 수 있도록 ServletAppContext 클래스에 "@PropertySource" annotation 을 이용하여  
   .properties 파일의 경로를 반드시 설정해준다.**   


      ex1) .properties 파일을 사용하기 위한 Bean 등록 예시.
      <context:property-placeholder location="/WEB-INF/properties/database.properties"/>

      
      ex2) BasicDataSource 예시.
      <beans:bean class="org.apache.commons.dbcp2.BasicDataSource" id="basicDataSource">
          <beans:property name="driverClassName" value="${db.drv}"/>
          <beans:property name="url" value="${db.url}"/>
          <beans:property name="username" value="${db.usr}"/>
          <beans:property name="password" value="${db.pwd}"/>
      </beans:bean>


4. SqlSessionFactoryBean 을 정의한다.  
이 객체는 query 문과 서버 접속정보를 다루는 역할을 맡는다.


        ex) SqlSessionFactory 예시
        <beans:bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSession">
            <beans:property name="dataSource" ref="basicDataSource"/>
            <beans:property name="mapperLocations" value="WEB-INF/mapper/*.xml"/>
        </beans:bean>


5. SqlSessionTemplate Bean 을 정의한다.  
여기서 주입한 Mapper 안에 있는 query 문을 실행한다.
   

      ex) MapperFactoryBean 예시
      <beans:bean class="org.mybatis.spring.SqlSessionTemplate" id="sessionTemplate">
            <beans:constructor-arg index="0" ref="sqlSession"/>
      </beans:bean>


# 사용하기.


1. 서버에서 받은 data 를 주입할 Bean 생성.
    * **이 때, 서버의 컬럼명과 해당 컬럼의 데이터를 받을 변수의 이름이 완전히 일치해야 한다.**


2. 컨트롤러 내에서 Mapper 를 자동주입.  
    

    ex)
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;


3. 매핑 시 자동주입한 Mapper 를 사용.  
   이 때, 해당 Mapper 안에 있는 쿼리문 중  
   원하는 쿼리문을 선택하여 Bean 주입(mapper.insert_data(bean)).


    ex)Controller 예시.
    @Controller
    public class TestController {

        @Autowired
        SqlSessionTemplate sqlSessionTemplate;
    
        ...


        @PostMapping("input_prop")
        public String inputProp(myBatisBean bean) {
            sqlSessionTemplate.insert("test_db.insert_data", bean);
    
            return "input_success";
        }
    
        ...

    }
