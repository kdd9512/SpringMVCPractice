package controller.InterceptorXml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @GetMapping("t2")
    public String test2(){
        System.out.println("test2");
        return "test2";
    }

    @GetMapping("sub1/t3")
    public String subTest3(){
        System.out.println("sub1/test3");
        return "test3";
    }

    @GetMapping("sub1/t4")
    public String subTest4(){
        System.out.println("sub1/test4");
        return "test4";
    }

}
