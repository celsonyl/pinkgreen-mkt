package br.com.pinkgreen.mkt.controller.handler.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

    private String message;
    private String path;
}
