package controller.MyBatisXml;

import controller.MyBatisXml.beans.myBatisBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("input_data")
    public String inputData(){

        return "input_data";
    }

    @PostMapping("input_prop")
    public String inputProp(myBatisBean bean){

        sqlSessionTemplate.insert("test_db.insert_data", bean);
        return "input_success";
    }

    @GetMapping("read_data")
    public String readData(Model md){
        List<myBatisBean> list = sqlSessionTemplate.selectList("test_db.select_data");
        md.addAttribute("list",list);

        return "read_data";
    }
}
