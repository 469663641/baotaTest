package com.example.service;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by baota on 2017/10/7.
 */
@Slf4j
public class FutureTest {
    @Test
    public void test(){
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        AtomicInteger success = new AtomicInteger(0);
        AtomicInteger error = new AtomicInteger(0);
        List<Integer> list = new ArrayList<>();
        for (Integer i=0;i<20;i++) {
            list.add(i);
        }

        List<ListenableFuture<Integer>> futures = new ArrayList<>();
        for (Integer i :list){
            ListenableFuture<Integer> future = pool.submit(() -> fun(i));
            Futures.addCallback(future, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(Integer integer) {
                    int successIndex = success.incrementAndGet();
                }
                @Override
                public void onFailure(Throwable throwable) {
                    int errorIndex = error.incrementAndGet();
                }
            });
            futures.add(future);
        }

        ListenableFuture<List<Integer>> successList = Futures.successfulAsList(futures);
        int rtn = 0;
        try {
            List<Integer> integers =successList.get();
            for (Integer integer :integers){
                if (integer != null) {
                    rtn += integer;
                }
            }
            System.err.println(rtn);
        } catch (InterruptedException  | ExecutionException e) {
            log.error("async entrusted cases error {}", e.getMessage());
        }
        pool.shutdown();
    }

    private Integer fun(Integer i){
        System.err.println("++++++"+i);
        return 1;
    }
}
