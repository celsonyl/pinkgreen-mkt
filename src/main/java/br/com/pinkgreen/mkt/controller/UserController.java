package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.UserControllerApi;
import br.com.pinkgreen.mkt.controller.model.UserRequest;
import br.com.pinkgreen.mkt.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final CreateUserUseCase createUserUseCase;

    @Override
    public ResponseEntity<Void> create(
            UserRequest body,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        createUserUseCase.execute();
        return ok().build();
    }
}
