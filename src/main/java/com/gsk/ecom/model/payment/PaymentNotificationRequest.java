package com.gsk.ecom.model.payment;

import lombok.Builder;

@Builder
public record PaymentNotificationRequest(
        String orderReference,
        Double amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}