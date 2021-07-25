package com.seeini.stack.controller.rest;


import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.common.response.ResponseUtil;
import com.seeini.stack.service.GuidelinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("guidelines")
public class GuidelinesController {

    @Resource
    private GuidelinesService guidelinesService;

    @PostMapping("list")
    public ResponseData list(@RequestBody RequestData requestData) {
        try {
            return ResponseUtil.success(guidelinesService.list(requestData));
        } catch (Exception e){
            log.error("GuidelinesController list() error reason :{}", e.getMessage());
            return ResponseUtil.error(e.getLocalizedMessage());
        }
    }


}
