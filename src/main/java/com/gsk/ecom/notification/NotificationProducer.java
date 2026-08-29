package com.gsk.ecom.notification;

import com.gsk.ecom.model.payment.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.json.JsonMapper;

@Configuration
@RequiredArgsConstructor
public class NotificationProducer {

   /* @Autowired
    private final KafkaTemplate<String, OrderNotificationRequest> kafkaTemplate;

    public void sendNotification(OrderNotificationRequest request) {
        Message<OrderNotificationRequest> message = MessageBuilder.withPayload(request)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();
        kafkaTemplate.send(message);
    }*/

    private final PubSubTemplate pubSubTemplate;
    private final JsonMapper objectMapper;

    public void sendNotification(PaymentNotificationRequest request) {
        String payload = objectMapper.writeValueAsString(request);
        pubSubTemplate.publish("order-topic", payload);
    }
}