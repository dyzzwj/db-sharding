package com.dyzwj.dbsharding.dao;

import com.dyzwj.dbsharding.po.OrderPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName OrderDao.java
 * @Description TODO
 * @createTime 2020年04月28日 21:41:00
 */
@Mapper
public interface OrderDao {


    @Insert("insert into t_order(price,user_id,status) values(#{price},#{userId},#{status})")
    int insertOrder(OrderPO orderPO);



    @Select("<script>" +
            "select * " +
            "from t_order t " +
            "where t.order_id in " +
            "<foreach collection='orderIds' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<OrderPO> selectOrderById(@Param("orderIds") List<Long> orderIds);


    @Select("<script>" +
            "select * " +
            "from t_order t " +
            "where t.order_id in " +
            "<foreach collection='orderIds' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            " and user_id = #{userId}" +
            "</script>")
    List<OrderPO> selectOrderByUserAndOrderId(@Param("orderIds") List<Long> orderIds,Long userId);

    @Select("select * from t_order where order_id = #{id1} or order_id = #{id2}")
    List<OrderPO> selectOrder(Long id1,Long id2);


    @Select("select * from t_order where order_id = #{orderId}")
    List<OrderPO> select1(Long orderId);


}
