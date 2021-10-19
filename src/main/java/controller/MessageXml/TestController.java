package controller.MessageXml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // MessageSource 를 주입받는다.

    @Autowired
    ReloadableResourceBundleMessageSource res;

    @GetMapping("t1")
    public String test1(){

        String data1 = res.getMessage("prop1.data1",null,null);
        String data2 = res.getMessage("prop1.data2",null,null);

        System.out.printf("prop1.data1 : %s\n", data1);
        System.out.printf("prop1.data2 : %s\n", data2);

        return "test1";
    }
}
