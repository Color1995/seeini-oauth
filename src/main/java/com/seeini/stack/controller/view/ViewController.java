package com.seeini.stack.controller.view;

import com.seeini.stack.service.GuidelinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller("stackViewController")
public class ViewController {

    @Resource
    private GuidelinesService guidelinesService;

    @GetMapping("/")
//    public String redirectIndex(){
//        return "redirect:/index";
//    }
    public String redirectIndex(){
        return "stack/index";
    }

    @GetMapping("index")
    public String index(ModelMap map){

        List list = guidelinesService.list(null,9);

        map.put("guidelines",list);

        return "stack/index";
    }

    @GetMapping("about-us")
    public String aboutUs(){

        return "stack/about-us";
    }

    @GetMapping("contact-us")
    public String contactUs(){

        return "stack/contact-us";
    }

    @GetMapping("footer")
    public String footer(){

        return "stack/common/footer";
    }

    @GetMapping("head")
    public String head(){

        return "stack/common/header";
    }
}
