package com.gsk.ecom.mapper.payment;

import com.gsk.ecom.model.payment.PaymentMethod;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Integer id;
    private Double amount;
    private PaymentMethod paymentMethod;

    private Integer orderId;

     private LocalDateTime createdDate;

   private LocalDateTime lastModifiedDate;
}
