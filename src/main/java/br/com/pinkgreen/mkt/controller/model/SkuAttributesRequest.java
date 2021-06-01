package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class SkuAttributesRequest {

    private String label;
    private String type;
    private String value;
}
