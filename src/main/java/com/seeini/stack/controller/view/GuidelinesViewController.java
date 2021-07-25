package com.seeini.stack.controller.view;


import com.seeini.stack.entity.Guidelines;
import com.seeini.stack.service.GuidelinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class GuidelinesViewController {

    private static final String reqPara = "guidelines/";

    @Resource
    private GuidelinesService guidelinesService;


    /**
     * 随机推荐十个，热点方向
     * @return
     */
    @RequestMapping("guidelines")
    public String guidelines(Model model) {


        Map map = new HashMap();

        List<Guidelines> guidelines =  guidelinesService.list(new String[]{"publish_time"},10);

        map.put("guidelines",guidelines);

        model.addAllAttributes(map);

        return "stack/guidelines/guidelines";
    }


    /**
     * 随机推荐前三个，技术解决方案，案例
     * @return
     */
    @RequestMapping("guidelines/detail/{id}")
    public String guidelinesDetail(@PathVariable("id") Integer id) {

        Map json = new HashMap();

        Map map = new HashMap();

        List<Guidelines> guidelines =  guidelinesService.list(new String[]{"publish_time"},10);

        map.put("guidelines",guidelines);

        return "stack/guidelines/guidelines-detail";
    }

    /**
     * Top10 点击
     * @return
     */
    @RequestMapping("guidelines/hot")
    public String hot() {

        Map json = new HashMap();

        Map map = new HashMap();

        List<Guidelines> guidelines =  guidelinesService.list(null,10);

        map.put("guidelines",guidelines);

        return "stack/hot";
    }
}
