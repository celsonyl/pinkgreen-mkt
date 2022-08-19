package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@SuppressWarnings("unused")
@RestController
public interface UserControllerApi {
    ResponseEntity<Void> create(UserRequest body, UriComponentsBuilder uriComponentsBuilder);
}
