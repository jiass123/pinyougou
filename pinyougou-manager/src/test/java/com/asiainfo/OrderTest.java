package com.asiainfo;


import com.asiainfo.rabbitmq.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Test
    public void orderTest(){
        Order order = new Order();
        order.setOrderId(1);
        System.out.println(order.toString());
    }
}
