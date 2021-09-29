package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 여기다 RequestMapping 어노테이션을 이용하여 입력하면 반복되는 부분을 통합하여 이하에서 path 를 관리하기 쉬워진다.
// 물론 매 번 호출 시 path 에 주소를 입력해주어도 작동은 하나, 프로젝트의 크기가 커질 경우,
// 컨트롤러 관리가 매우 까다로워지므로 이 방법이 추천된다.
@RequestMapping("/t1")
public class TestSubController {

    @RequestMapping(path = "/sub1", method = RequestMethod.GET)
    public String sub1(){
        return "sub/sub1";
    }

    @RequestMapping(path = "/sub2", method = RequestMethod.GET)
    public String sub2(){
        return "sub/sub2";
    }
}
