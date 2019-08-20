package com.amirahmed.hatly.Models;

public class OrderItem {

    int orderPic;
    String orderName;
    String orderPrice;
    String orderStatus;

    public OrderItem(int orderPic, String orderName, String orderPrice, String orderStatus) {
        this.orderPic = orderPic;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
    }

    public int getOrderPic() {
        return orderPic;
    }

    public void setOrderPic(int orderPic) {
        this.orderPic = orderPic;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
