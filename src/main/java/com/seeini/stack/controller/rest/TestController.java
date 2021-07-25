package com.seeini.stack.controller.rest;

import com.seeini.common.config.ThreadPoolConfig;
import com.seeini.stack.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;


    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    //
    @PostMapping("1111")
    public String test1(HttpServletRequest request){

        System.out.println(request.getMethod());

        Map res = new HashMap();
        res.put("status",true);
        res.put("data","1111");


        this.A();

        try {
            testService.sendMes();
        } catch (Exception e){

        }

//        try {
//            testService.sendMail();
//        } catch (Exception e){
//
//        }

        this.B();


        return res.toString();
    }

    private void A(){
        System.out.println("AAAAAAAAAAA");
    }

    private void B(){
        System.out.println("BBBBBBBBBBB");
    }


    @GetMapping("222")
    public String test2(){
//        Executor executor = threadPoolConfig.executor(20,40,Integer.MAX_VALUE,60,"AsyncExportExcelThreadPool-");
        List total = getList();

        int outSendTimes = total.size() / 10000;
        if (total.size() % 10000 > 0) {
            outSendTimes += 1;
        }
        //将list 切分多份 多线程执行
        int outListStart,outListEnd;


        for (int j = 0; j < outSendTimes; j++){

            outListStart = total.size() / outSendTimes * j;
            outListEnd = total.size() / outSendTimes * ( j + 1 );
            if(j == outSendTimes - 1){
                outListEnd = total.size();
            }

            List list = total.subList(outListStart,outListEnd);



            int kafkaSize = 50;

            //集合总条数
            int size = list.size();
            // 发送次数
            int sendTimes = size / kafkaSize;
            if (list.size() % kafkaSize > 0) {
                sendTimes += 1;
            }
            //将list 切分多份 多线程执行
            int listStart,listEnd;

//这个类使一个线程等待其他线程各自执行完毕后再执行。(一般在查询的时候使用)
//            CountDownLatch countDownLatch = new CountDownLatch(sendTimes);

            for (int i = 0; i < sendTimes; i++){

                //计算切割  开始和结束
                listStart = size / sendTimes * i ;
                listEnd = size / sendTimes * ( i + 1 );

                //计算切割  开始和结束
//            listStart = kafkaSize * i ;
//            listEnd = kafkaSize * ( i + 1 );
                //最后一段线程会出现与其他线程不等的情况
                if(i == sendTimes - 1){
                    listEnd = size;
                }
                //
                List batchRecords = list.subList(listStart,listEnd);

//            int finalAllTimes = allTimes;
//            int finalIdx = idx;
//            int finalDbSearchTimes = dbSearchTimes;
                int finalSendTimes = sendTimes;
                int finalI = i;

//                executor.execute(()->{
//
//                    for (Object s:batchRecords ) {
//                        System.out.println(s);
//                    }
//                    countDownLatch.countDown();
//                });

                for (Object s:batchRecords ) {
                    System.out.println(s);
                }

            }

//            try {
//                //此处还可以设置等待时间 countDownLatch.await(3,TimeUnit.MILLISECONDS); 三分钟
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                log.error("AsyncExportPDF countDownLatch await exception: {}", e);
//                e.printStackTrace();
//            }

        }

        return null;
    }

    private List getList(){

        List l = new ArrayList();
        for (int i=0; i<320006; i++){
            l.add(i);
        }

        return l;
    }
}
