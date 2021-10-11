package controller.RequestScopeBeanXml;

import controller.RequestScopeBeanXml.beans.DataBean;
import controller.RequestScopeBeanXml.beans.DataBean2;
import controller.RequestScopeBeanXml.beans.DataBean3;
import controller.RequestScopeBeanXml.beans.DataBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    // root-context.xml 에서 정의한 Bean 을 자동주입한다. DataBean 타입으로 주입받고 이름을 reqBean1 로 설정.
    // Bean 주입은 요청이 있을 때만 주입된다.
    // 여기서 주의할 점은 score 를 request 로 설정했다는 것으로, 요청이 있을 때만 bean 을 주입하겠단 의미이기 때문에
    // request 에는 값이 저장되지 않는다는 점이다.(default 값은 "요청없음" 이니까)
    // 즉, 내부 요소를 활용하려면 Model 에 따로 담은다음 HttpServletRequest 로 불러와야 한다.


    // Autowired 혹은 Resource 만 사용하면, 500에러 발생.
    // 이유 :
    // JAVA 방식의 경우에는 요청이 없더라도 bean 주입을 시도하려 한다.
    // 하지만 xml 의 경우 scope 에서 요청이 있을 때만 주입하도록 request 로 설정을 해놓았기 때문에, 멋대로 주입하는
    // bean 은 전부 거부해 버리기 때문에 생기는 오류이다.
    // 이 경우, 자동 주입을 나중으로 미뤄 서버가 가동해도 자동주입이 되지 않도록 막아버리면 오류가 해결될 것이다.
    @Autowired @Lazy
    DataBean reqBean1;

    @Resource(name = "reqBean2") @Lazy
    DataBean2 reqBean2;

    // @Component 를 이용하여 Bean 주입. 이 방식을 이용하면 root-context.xml 에서 Bean 을 또 정의할 필요가 없다.
    // 그리고 JAVA 방식에서 했던 대로( ServletAppContext 에서 @ComponentScan(bean 경로)),
    // servlet-context.xml 에서
    // <context:component-scan base-package="controller.RequestScopeBeanXml.beans"/> 을 추가해야 함.
    @Autowired @Lazy
    DataBean3 reqBean3;

    @Resource(name = "reqBean4") @Lazy
    DataBean4 reqBean4;


    @GetMapping("t1")
    public String test1() {
        reqBean1.setData1("string1");
        reqBean1.setData2("string2");

        reqBean2.setData3("string3");
        reqBean2.setData4("string4");

        reqBean3.setData5("string5");
        reqBean3.setData6("string6");

        reqBean4.setData7("string7");
        reqBean4.setData8("string8");

        return "forward:result";
    }

    @GetMapping("result")
    public String result1(Model model) {

        System.out.printf("reqBean1.data1 : %s\n", reqBean1.getData1());
        System.out.printf("reqBean1.data2 : %s\n", reqBean1.getData2());

        System.out.printf("reqBean2.data3 : %s\n", reqBean2.getData3());
        System.out.printf("reqBean2.data4 : %s\n", reqBean2.getData4());

        System.out.printf("reqBean3.data5 : %s\n", reqBean3.getData5());
        System.out.printf("reqBean3.data6 : %s\n", reqBean3.getData6());

        System.out.printf("reqBean4.data7 : %s\n", reqBean4.getData7());
        System.out.printf("reqBean4.data8 : %s\n", reqBean4.getData8());

        model.addAttribute("reqBean1", reqBean1);
        model.addAttribute("reqBean3", reqBean3);

        // 얼핏 reqBean4 는 이름을 지정했으니 자동저장될 것 같지만,
        // XML 에(root-context.xml 파일 내부에) bean 을 직접 설정한 것이 아니므로 자동저장되지 않는다.
        // 그러므로 model 클래스를 이용하여 값을 저장해주어야 함.
        model.addAttribute("reqBean4", reqBean4);

        // reqBean2는 XML 로 bean 을 "직접 설정"하고 byName 으로 주입받았으므로 request 영역에 자동으로 저장된다.
        // 즉, Model 을 이용하지 않아도 알아서 값이 request 영역에 저장되어 넘어온다.
        //  model.addAttribute("reqBean2", reqBean2);



        return "result";
    }

}
