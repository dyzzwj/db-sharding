package com.dyzwj.dbsharding;

import com.dyzwj.dbsharding.dao.OrderDao;
import com.dyzwj.dbsharding.dao.UserDao;
import com.dyzwj.dbsharding.po.OrderPO;
import com.dyzwj.dbsharding.po.UserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbShardingApplicationTests {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void test1(){

        for (int i = 0; i < 20; i++) {
            OrderPO orderPO = new OrderPO();
            orderPO.setPrice(new BigDecimal(1));
            orderPO.setUserId(2L);
            orderPO.setStatus("已发货");

            orderDao.insertOrder(orderPO);
        }
    }


    @Test
    public void test2(){
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(463289852155133952L);
//        orderIds.add(463289321881862145L);
//        orderIds.add();
        List<OrderPO> orderPOList = orderDao.selectOrderById(orderIds);
        orderPOList.forEach(x -> System.out.println(x));
    }

    @Test
    public void test3(){
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(463289852155133952L);
        orderIds.add(463289321881862145L);
        orderDao.selectOrderByUserAndOrderId(orderIds,2L);
    }

    @Autowired
    private UserDao userDao;

    @Test
    public void test4(){
        UserPO userPO = new UserPO();
        userPO.setUserId(1L);
        userPO.setFullname("郑文杰");
        userPO.setUserType("1");
        userDao.insertUser(userPO);
    }

}
