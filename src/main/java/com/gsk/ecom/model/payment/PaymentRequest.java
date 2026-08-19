package com.gsk.ecom.model.payment;

public record PaymentRequest(
        Integer id,
        Double amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer

) {
}
