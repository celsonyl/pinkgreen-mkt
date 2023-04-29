package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "CUSTOMER_CATEGORY_INTENTIONS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCategoryIntentionsDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerId;
    private Integer counter;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private CategoryDatabase category;
}
