package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class SkuAttributesResponse implements Serializable {

    private String label;
    private String type;
    private String value;
}
