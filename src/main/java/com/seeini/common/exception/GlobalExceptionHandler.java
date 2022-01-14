package com.seeini.common.exception;

import com.google.gson.Gson;
import com.seeini.common.response.ResponseData;
//import com.seeini.common.response.ResponseStatus;
import com.seeini.common.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.*;

/**
 * @Author Color
 * @Date 2021/7/14 10:38
 * @Version 1.0
 * @Description
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseData handleConstraintViolationException(ConstraintViolationException e) {

        ResponseData resData = new ResponseData();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        Map<String, String> msgMap = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            // TODO 待修改
//            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");

        }
        resData.setData(msgMap);
        resData.setResponseStatus(com.seeini.common.response.ResponseStatus.BAD_REQUEST);
        return resData;
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    public ResponseData validExceptionHandler(BindException e) {

        Gson gson = new Gson();
        Map errorMap = new LinkedHashMap();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            errorMap.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseData(ResponseStatus.BAD_REQUEST,errorMap);
//        return new ResponseData(ResponseStatus.BAD_REQUEST,errorMap);
    }

//    /**
//     * 处理其他异常
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ResponseEntity exceptionHandler(Exception e) {
//        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
