package com.pratap.estore.payment.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payments")
@NoArgsConstructor
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = -9143443403036543586L;

    @Id
    private String paymentId;

    @Column
    private String orderId;
}
