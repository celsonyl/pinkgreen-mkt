package br.com.pinkgreen.mkt.gateway.feign.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ResponseBankSlipPaymentModel {
    private String paymentId;
    private String barcode;
    private LocalDate dueDate;
}
