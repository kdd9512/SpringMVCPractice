package controller.ApplicationScopeXml;

import controller.ApplicationScopeXml.beans.AppliScopeBean;
import controller.ApplicationScopeXml.beans.AppliScopeBean2;
import controller.ApplicationScopeXml.beans.AppliScopeBean3;
import controller.ApplicationScopeXml.beans.AppliScopeBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Autowired
    AppliScopeBean appBean;

    @Resource(name = "appBean2")
    AppliScopeBean2 appBean2;

//  appBean3 과 appBean4 는 component-scan 을 이용한 bean 주입.
    @Autowired
    AppliScopeBean3 appBean3;

    @Resource(name = "appBean4")
    AppliScopeBean4 appBean4;

    @GetMapping("t1")
    public String test1(){
        appBean.setData1("application(type)");
        appBean.setData2("scope(type)");

        appBean2.setData3("application(name)");
        appBean2.setData4("scope(name)");

        appBean3.setData5("application(component)");
        appBean3.setData6("scope(component)");

        appBean4.setData7("application(component byName)");
        appBean4.setData8("scope(component byName)");

        return "test1";
    }

    @GetMapping("result")
    public String result1(Model md){

        System.out.printf("appBean.data1 : %s\n", appBean.getData1());
        System.out.printf("appBean.data2 : %s\n", appBean.getData2());

        System.out.printf("appBean2.data3 : %s\n", appBean2.getData3());
        System.out.printf("appBean2.data4 : %s\n", appBean2.getData4());

        System.out.printf("appBean3.data5 : %s\n", appBean3.getData5());
        System.out.printf("appBean3.data6 : %s\n", appBean3.getData6());

        System.out.printf("appBean4.data7 : %s\n", appBean4.getData7());
        System.out.printf("appBean4.data8 : %s\n", appBean4.getData8());

        md.addAttribute("appBean",appBean);
        md.addAttribute("appBean3",appBean3);
        md.addAttribute("appBean4",appBean4);

//        XML 로 bean 을 "직접 설정"하고 이름으로(byName) 주입받았으므로
//        applicationScope 영역에 자동으로 저장된다.
//        즉, Model 을 이용하지 않아도 알아서 값이 applicationScope 영역에 저장되어 넘어온다.
//        md.addAttribute("appBean2",appBean2);

        return "result";
    }

}
