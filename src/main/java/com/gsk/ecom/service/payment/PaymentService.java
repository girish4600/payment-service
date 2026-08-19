package com.gsk.ecom.service.payment;

import com.gsk.ecom.model.payment.PaymentRequest;
import com.gsk.ecom.model.payment.PaymentResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface PaymentService {
    @Nullable Integer createPayment(@Valid PaymentRequest paymentRequest);

    PaymentResponse findById(Integer paymentId);
}
