package com.gsk.ecom.service.payment;

import com.gsk.ecom.mapper.payment.Payment;
import com.gsk.ecom.mapper.payment.PaymentMapper;
import com.gsk.ecom.model.payment.PaymentMethod;
import com.gsk.ecom.model.payment.PaymentRequest;
import com.gsk.ecom.model.payment.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final Map<Integer, PaymentResponse> payments;
    private static Integer paymentId = 1;

    PaymentServiceImpl() {
        payments = new HashMap<>();
    }


//    @Autowired
//    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper mapper;

//    @Autowired
//    private NotificationProducer notificationProducer;

    @Override
    public @Nullable Integer createPayment(PaymentRequest paymentRequest) {
        log.info("======================== Generating payment ========================");
        PaymentResponse payment = mapper.dtoToEntity(paymentRequest, paymentId);
         payments.put(paymentId++, payment);
        log.info("Customer Details :: {}",paymentRequest.customer());
       /* notificationProducer.sendNotification(
               new PaymentNotificationRequest(
                       paymentRequest.orderReference(),
                       paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );*/
        return payment.id();
    }

    @Override
    public PaymentResponse findById(Integer paymentId) {
        log.info("checking payment with ID :: {}",paymentId);
//        mapper.entityToDto(payments.get(paymentId))
        PaymentResponse paymentResponse = payments.get(paymentId);
        if (paymentResponse == null) {
            throw new RuntimeException("CustomerNotFound for customerId :: " + paymentId);
        }
        return paymentResponse;
    }
}
