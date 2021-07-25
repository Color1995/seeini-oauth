package com.seeini.stack.service.impl;

import com.seeini.common.config.ThreadPoolConfig;
import com.seeini.stack.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    @Override
    @Async
    public void sendMes() throws InterruptedException {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        System.out.println(request.getContextPath());
//        Thread.sleep(5000);
        System.out.println("sendMes Start");
//        System.out.println("C Start");



        for (int j=0; j<5; j++){
            int count = 10;
            Executor executor = threadPoolConfig.executor();
            //这个类使一个线程等待其他线程各自执行完毕后再执行。(一般在查询的时候使用)
            CountDownLatch countDownLatch = new CountDownLatch(count);

            for (int i=0; i<count; i++){
                int finalI = i;
                int finalJ = j;
                executor.execute(()-> {

//                    System.out.println("CCCCCCCCCCC:"+ finalI);
                    log.info("Excel多线程：{}， 父：{}，子：{}",Thread.currentThread().getName(), finalJ,finalI);
                    countDownLatch.countDown();
                });

//                ThreadPoolTaskExecutor executor1 = new ThreadPoolTaskExecutor();

            }

            try {
                //此处还可以设置等待时间 countDownLatch.await(3,TimeUnit.MILLISECONDS); 三分钟
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("C End");
        System.out.println("sendMes End");
    }

    @Override
    @Async
    public void sendMail() throws InterruptedException {

        System.out.println("sendMail Start");
        this.D();
        Thread.sleep(5000);
        System.out.println("sendMail End");
    }

    void C(){

    }

    private void D(){
        Executor executor = threadPoolConfig.executor();
        for (int i=0; i<50; i++){
            executor.execute(()->{
                System.out.println("DDDDDDDDDDD");
            });
        }

    }
}
