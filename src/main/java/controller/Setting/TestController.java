package controller.Setting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public String test1() {
        return "test1";
    }

    @RequestMapping(value = "/t2", method = RequestMethod.GET)
    public String test2() {
        return "test2";
    }
}
