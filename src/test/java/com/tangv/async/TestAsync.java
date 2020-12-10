package com.tangv.async;

import com.tangv.demo.DemoApplication;
import com.tangv.demo.dao.DataMapper;
import com.tangv.demo.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/21 10:35 上午
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class TestAsync {

    @Autowired
    private DataMapper dataMapper;

    @Test
    public void testThread() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        log.debug("{}函数开始执行",Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            log.debug("{}开始执行",Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                log.debug("{}结束",Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (latch != null) {
                    latch.countDown();
                }
            }
        },"任务");
        thread.start();
        latch.await();
        log.debug("{}函数结束执行",Thread.currentThread().getName());
    }

    @Test
    public void testCompletableFuture() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        log.debug("main函数开始执行");
    ExecutorService executor = Executors.newFixedThreadPool(2);
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.debug("异步任务开始");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }finally {
                if (latch != null) {
                    latch.countDown();
                }
            }
            log.info("异步任务结束");
            return 3;
        },executor);
    latch.await();
    executor.shutdown();
    future.thenAccept(e -> log.debug(e.toString()));
    }

    @Test
    public void testFuture() {
        List<Data> dataList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService excutor = Executors.newFixedThreadPool(3);
        FutureTask<Data> futureTask = new FutureTask<>(() -> {
            Data data = dataMapper.selectByPrimaryKey(20);
            return data;
        });
        for (int i = 0;i < 3;i++) {
            excutor.submit(futureTask);
            try {
                dataList.add(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (Data data : dataList) {
            log.debug("id:{};data:{}",data.getId(),data.getData());
        }
    }

}
