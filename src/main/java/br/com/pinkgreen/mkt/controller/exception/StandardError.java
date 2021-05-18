package br.com.pinkgreen.mkt.controller.exception;

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
