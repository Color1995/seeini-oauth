package com.seeini.stack.controller.rest;


import com.seeini.common.response.ResponseData;
import com.seeini.common.response.ResponseUtil;
import com.seeini.stack.entity.GuidelinesDetail;
import com.seeini.stack.service.GuidelinesDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("guidelines/detail")
@RestController
public class GuidelinesDetailController {

    @Autowired
    private GuidelinesDetailService guidelinesDetailService;

    @RequestMapping("get/{id}")
    public ResponseData detail(@PathVariable("id") Long id){

        GuidelinesDetail detail =  guidelinesDetailService.selectByPrimaryKey(id);

        return ResponseUtil.success(detail);
    }

}
