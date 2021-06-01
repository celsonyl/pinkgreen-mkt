package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductAttributesDomain implements Serializable {
    private String label;
    private String type;
    private List<String> values;
}
