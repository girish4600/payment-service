package com.gsk.ecom.mapper.payment;


import com.gsk.ecom.model.payment.PaymentRequest;
import com.gsk.ecom.model.payment.PaymentResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentMapper {
    public PaymentResponse dtoToEntity(PaymentRequest paymentRequest) {
        return PaymentResponse.builder()
                .amount(paymentRequest.amount())
                .paymentMethod(paymentRequest.paymentMethod())
                .orderId(paymentRequest.orderId())
                .build();
    }

    public PaymentResponse entityToDto(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .orderReference("")
                .amount(payment.getAmount())
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .build();
    }
}
