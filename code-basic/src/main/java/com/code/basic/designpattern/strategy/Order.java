package com.code.basic.designpattern.strategy;


/**
 * 订单
 *
 * @author FengDuo
 * @date 2022/8/29 11:28
 */
public class Order {

    private PaymentStrategy payment;

    public void setPayment(PaymentStrategy payment) {
        this.payment = payment;
    }

    public PaymentStrategy getPayment() {
        return payment;
    }

    public void payWithOrder(){
        payment.pay();
    }
}
