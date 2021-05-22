package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductAttributesDomain {
    private String label;
    private String type;
    private List<String> values;
}
