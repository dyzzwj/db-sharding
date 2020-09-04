package com.dyzwj.dbsharding.po;

import java.math.BigDecimal;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName OrderPO.java
 * @Description TODO
 * @createTime 2020年04月28日 21:43:00
 */
public class OrderPO {

    private Long orderId;

    private BigDecimal price;

    private Long userId;

    private String status;



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderPO{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
