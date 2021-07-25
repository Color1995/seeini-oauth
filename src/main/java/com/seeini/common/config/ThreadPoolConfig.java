package com.seeini.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Vincent
 * @Date 2021/5/20 17:37
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    //接收报文核心线程数
//    @Value("${threadPool.core.poolsize}")
    private int corePoolSize;
    //接收报文最大线程数
//    @Value("${threadPool.max.poolsize}")
    private int maxPoolSize;
    //接收报文队列容量
//    @Value("${threadPool.queue.capacity}")
    private int queueCapacity;
    //接收报文线程活跃时间（秒）
//    @Value("${threadPool.keepAlive.seconds}")
    private int keepAliveSeconds;

    //接收报文默认线程名称
//    @Value("${threadPool.thread.name.prefix}")
    private String threadNamePrefix;

    private ThreadPoolTaskExecutor executor;

    ThreadPoolConfig(){
        this.corePoolSize = 20;
        this.maxPoolSize = 40;
        this.queueCapacity = Integer.MAX_VALUE;
        this.keepAliveSeconds = 60;
        this.threadNamePrefix = "ThreadPool-";
    }


    public Executor executor() {
        //newFixedThreadPool
        executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix(threadNamePrefix);
        // 设置拒绝策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        executor.initialize();

        return executor;
    }


    public ThreadPoolTaskExecutor executor(int corePoolSize, int maxPoolSize, int queueCapacity, int keepAliveSeconds, String threadNamePrefix) {
        //newFixedThreadPool
        executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix(threadNamePrefix);
        // 设置拒绝策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

}
