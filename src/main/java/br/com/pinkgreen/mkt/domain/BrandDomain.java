package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BrandDomain implements Serializable {

    private Integer id;
    private String name;
    private String brandImage;
}
