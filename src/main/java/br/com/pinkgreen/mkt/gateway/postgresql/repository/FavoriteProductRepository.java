package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.FavoriteProductDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FavoriteProductRepository extends JpaRepository<FavoriteProductDatabase, Integer> {

    List<FavoriteProductDatabase> getFavoriteProductDatabaseByUserIdAndProductId(String userId, Integer productId);

    @Transactional
    void deleteByUserIdAndProductId(String userId, Integer productId);
}
