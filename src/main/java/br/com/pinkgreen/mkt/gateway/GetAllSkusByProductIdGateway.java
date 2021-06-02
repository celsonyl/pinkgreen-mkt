package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.SkuDomain;

import java.util.List;

public interface GetAllSkusByProductIdGateway {

    List<SkuDomain> execute(Integer productId);
}
