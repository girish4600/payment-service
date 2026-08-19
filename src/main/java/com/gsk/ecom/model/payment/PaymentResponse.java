package com.gsk.ecom.model.payment;

import lombok.Builder;

@Builder
public record PaymentResponse(Integer id,
                              Double amount,
                              PaymentMethod paymentMethod,
                              Integer orderId,
                              String orderReference) {
}
