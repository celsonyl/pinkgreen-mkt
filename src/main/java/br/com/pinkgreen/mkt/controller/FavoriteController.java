package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.FavoriteControllerApi;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.gateway.FindFavoriteProductByCustomerIdGateway;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateFavoriteProductUseCase;
import br.com.pinkgreen.mkt.usecase.DeleteFavoriteProductByUserIdAndProductIdUserCase;
import br.com.pinkgreen.mkt.usecase.GetAllFavoriteProductsSkuByUserIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static br.com.pinkgreen.mkt.controller.util.VerifyCustomerId.getCustomerIdAndValidate;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;


@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController implements FavoriteControllerApi {
    private final GetAllFavoriteProductsSkuByUserIdUseCase getAllFavoriteProductsSkuByUserIdUseCase;
    private final FindFavoriteProductByCustomerIdGateway findFavoriteProductByCustomerIdGateway;
    private final DeleteFavoriteProductByUserIdAndProductIdUserCase deleteFavoriteProductByUserIdAndProductIdUserCase;
    private final CreateFavoriteProductUseCase createFavoriteProductUseCase;

    @Override
    @GetMapping("/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SkuResponse>> getAllFavoriteProductsByUserId(String userId, HttpServletRequest request) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), userId);

        var productsDomain = getAllFavoriteProductsSkuByUserIdUseCase.execute(userId);
        return ok().body(productsDomain.stream()
                .map(new SkuProductMapperImpl()::skuDomainToResponse)
                .collect(toList()));
    }

    @Override
    @GetMapping("/product/{skuCode}/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> getFavoriteProductByCustomerId(String userId, String skuCode, HttpServletRequest request) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), userId);
        Optional<FavoriteProductDomain> favoriteProductDomain = findFavoriteProductByCustomerIdGateway.execute(userId, skuCode);
        if (favoriteProductDomain.isEmpty()) return notFound().build();
        return noContent().build();
    }

    @Override
    @DeleteMapping("/product/{skuCode}/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteFavoriteProductsByUserIdAndProductId(String userId, String skuCode, HttpServletRequest request) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), userId);

        deleteFavoriteProductByUserIdAndProductIdUserCase.execute(userId, skuCode);
        return noContent().build();
    }

    @Override
    @PostMapping("/product/{skuCode}/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> createFavoriteProduct(String userId, String skuCode, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest request) throws InvalidCustomerIdException, DataIntegrityException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), userId);

        var favoriteProductDomain = createFavoriteProductUseCase.execute(new FavoriteProductDomain(userId, skuCode));
        var uri = uriComponentsBuilder.path("product/favorite_products/{id}").buildAndExpand(favoriteProductDomain.getId()).toUri();

        return created(uri).build();
    }
}
