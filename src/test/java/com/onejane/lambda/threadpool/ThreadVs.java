package com.onejane.lambda.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:46 2019/10/18 0018
 * @ Description ：
 */
public class ThreadVs {

    /**
     * 线程池 降低资源消耗 降低创建和销毁 随用随取，提高相应速度，提高线程的可管理性
     * ThreadPoolExecutor
     *  corePoolSize 核心线程数量
     *  maximumPoolSize 最大线程数量
     *  keepAliveTime 线程空闲后的存活时间
     *  unit 时间单位
     *  workQueue 用于存放任务的阻塞队列
     *  threadFactory 线程工厂类
     *  handler 当队列和最大线程池都满了后的饱和策略
     * @throws InterruptedException
     */
    @Test
    public void newHandle1() throws InterruptedException {


        // 开启线程池 10个线程
        ExecutorService threadpool = Executors.newFixedThreadPool(10);
        //使用循环来模拟许多用户请求的场景
        for(int request = 1; request < 100; request ++){
            threadpool.execute(() -> {
                System.out.println("文档处理开始!");

                try {
                    TimeUnit.MILLISECONDS.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("文档处理结束!");
            });
        }
        Thread.sleep(1000 * 100);
    }

    /**
     * 老的处理方式 处理线程过多
     */
    @Test
    public void oldHandle1() throws InterruptedException {
        /**
         * 使用循环模拟许多用户访问的场景
         */
        for(int request = 1; request <= 100; request++){
            new Thread(() -> {
                System.out.println("文档处理开始!");

                try {
                    //将 Word 转成 PDF 格式：处理时间很长的耗时过程
//                    Thread.sleep(1000L * 30);
                    TimeUnit.MILLISECONDS.sleep(1000 * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("文档处理结束!");
            }).start();
        }

        Thread.sleep(1000 * 1000);
    }

}
