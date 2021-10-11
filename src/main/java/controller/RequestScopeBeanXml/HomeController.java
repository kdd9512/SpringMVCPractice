package controller.RequestScopeBeanXml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // value 값에 적힌 주소를 요청했을 때, 이하 메서드를 GET 방식으로 호출

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Main(){
        System.out.println("home");
        return "index";
    }


}
