package com.seeini.stack.controller.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class QuestionViewController {

    /**
     * 此类的公共匹配路径
     */
    private static final String reqPara = "question/";

    @RequestMapping("question")
    public String question(){

        return "stack/question";
    }

}
