package com.pratap.estore.payment.handlers;

import com.pratap.estore.payment.data.PaymentEntity;
import com.pratap.estore.payment.data.PaymentRepository;
import com.pratap.estore.shared.events.PaymentProcessedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentEventsHandler {

    private final PaymentRepository paymentRepository;

    public PaymentEventsHandler(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent paymentProcessedEvent){

        log.info("PaymentProcessedEvent is called for orderId={}", paymentProcessedEvent.getOrderId());
        log.info("and going to save in to data base, PaymentProcessedEvent={}", paymentProcessedEvent);

        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(paymentProcessedEvent, paymentEntity);

        paymentRepository.save(paymentEntity);
    }
}
