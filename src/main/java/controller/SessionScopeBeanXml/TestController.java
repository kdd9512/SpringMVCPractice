package controller.SessionScopeBeanXml;

import controller.SessionScopeBeanXml.beans.DataBean1;
import controller.SessionScopeBeanXml.beans.DataBean2;
import controller.SessionScopeBeanXml.beans.DataBean3;
import controller.SessionScopeBeanXml.beans.DataBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    // 브라우저에서 최초의 요청이 발생하면 단 한번만 주입된다.

    // Autowired 혹은 Resource 만 사용하면, 500에러 발생.
    // 이유 :
    // XML 방식은 서버가 가동되었을 때, 무조건 Bean 주입을 시도한다.
    // 하지만, 이 예제에서는 bean 의 scope 를 request 로 설정하여 "요청이 있을 때만 주입되도록 했기 때문에",
    // 멋대로 주입되는 bean 은 전부 거부해 버려 생기는 오류이다.
    // 이 경우, 강제 주입을 나중으로 미뤄(@Lazy) 서버가 가동해도 자동주입이 되지 않도록 막아버리면 오류가 해결될 것이다.
    @Autowired @Lazy
    DataBean1 sessBean1;

    @Resource(name = "sessBean2") @Lazy
    DataBean2 sessBean2;

    @Autowired @Lazy
    DataBean3 sessBean3;

    @Resource(name = "sessBean4") @Lazy
    DataBean4 sessBean4;


    @GetMapping("t1")
    public String test1(){
        sessBean1.setData1("string1");
        sessBean1.setData2("string2");
        sessBean2.setData3("string3");
        sessBean2.setData4("string4");

        sessBean3.setData5("string5");
        sessBean3.setData6("string6");
        sessBean4.setData7("string7");
        sessBean4.setData8("string8");

        return "test1";
    }

    @GetMapping("result")
    public String result1(Model model){

        System.out.printf("sessBean1.data1 : %s\n", sessBean1.getData1());
        System.out.printf("sessBean1.data2 : %s\n", sessBean1.getData2());
        System.out.printf("sessBean2.data3 : %s\n", sessBean2.getData3());
        System.out.printf("sessBean2.data4 : %s\n", sessBean2.getData4());
        System.out.printf("sessBean3.data5 : %s\n", sessBean3.getData5());
        System.out.printf("sessBean3.data6 : %s\n", sessBean3.getData6());
        System.out.printf("sessBean4.data7 : %s\n", sessBean4.getData7());
        System.out.printf("sessBean4.data8 : %s\n", sessBean4.getData8());

        model.addAttribute("sessBean1", sessBean1);
        model.addAttribute("sessBean3", sessBean3);
        model.addAttribute("sessBean4", sessBean4);

//        XML 로 bean 을 "직접 설정"하고 이름으로(byName) 주입받았으므로 request 영역에 자동으로 저장된다.
//        즉, Model 을 이용하지 않아도 알아서 값이 request 영역에 저장되어 넘어온다.
//        model.addAttribute("sessBean2", sessBean2);


        return "result";
    }
}
