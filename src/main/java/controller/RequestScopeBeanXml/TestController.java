package controller.RequestScopeBeanXml;

import controller.RequestScopeBeanXml.beans.DataBean;
import controller.RequestScopeBeanXml.beans.DataBean2;
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
    @Autowired
    @Lazy
    DataBean reqBean1;

    @Resource(name = "reqBean2")
    @Lazy
    DataBean2 reqBean2;

    @GetMapping("t1")
    public String test1() {
        reqBean1.setData1("string1");
        reqBean1.setData2("string2");

        reqBean2.setData3("string3");
        reqBean2.setData4("string4");

        return "forward:result";
    }

    @GetMapping("result")
    public String result1(Model model) {

        System.out.printf("reqBean1.data1 : %s\n", reqBean1.getData1());
        System.out.printf("reqBean1.data2 : %s\n", reqBean1.getData2());

        System.out.printf("reqBean2.data3 : %s\n", reqBean2.getData3());
        System.out.printf("reqBean2.data4 : %s\n", reqBean2.getData4());

        model.addAttribute("reqBean1", reqBean1);

        // XML 로 bean 을 설정하고 byName 으로 주입받았을 경우에는 request 영역에 자동으로 저장된다.
        // 즉 이거 또 안해도 됌.
//        model.addAttribute("reqBean2", reqBean2);

        return "result";
    }

}
