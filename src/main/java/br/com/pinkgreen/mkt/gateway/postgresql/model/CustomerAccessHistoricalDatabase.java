package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "CUSTOMER_PRODUCT_ACCESS_HISTORICAL")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccessHistoricalDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerId;
    private Instant lastAccess;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductDatabase product;
}
