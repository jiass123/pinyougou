package com.asiainfo.concurrent;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ConcurrentTest {


    public static void main(String[] args) throws InterruptedException {
        Runnable taskTemp = new Runnable() {
            // 注意，此处是非线程安全的，留坑
            private int iCounter;
            @Override
            public void run() {
                for(int i = 0; i < 1; i++) {
                    iCounter++;
                    System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpPost httpPost = new HttpPost("http://localhost:8082/geec-order/api/v1/order/file");
                    httpPost.addHeader("token", "ZmVuZ3hpbmdjaGVuZDZkYjk4ZDE3ZGQ2N2ZlNjQxMjU0NmY2ZDdlYzAzMmNlNjkzMGY2OTE3ZDM3NTk1YTFiZDI3OWM5MzBkNzUwMw===");
                    List<BasicNameValuePair> content = new ArrayList<BasicNameValuePair>();
                    content.add(new BasicNameValuePair("url", "http://112.35.22.232:8025/release/image/1.txt"));
                    content.add(new BasicNameValuePair("filename", String.valueOf(new Date().getTime())));
                    content.add(new BasicNameValuePair("ext", "txt"));
                    content.add(new BasicNameValuePair("flowId", "5001"));
                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(content, "UTF-8"));
                        CloseableHttpResponse response = httpClient.execute(httpPost);
                        System.out.println(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ConcurrentTest latchTest = new ConcurrentTest();
        latchTest.startTaskAllInOnce(20
                , taskTemp);
    }
    public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for(int i = 0; i < threadNums; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endGate.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
        return endTime - startTime;
    }

}
