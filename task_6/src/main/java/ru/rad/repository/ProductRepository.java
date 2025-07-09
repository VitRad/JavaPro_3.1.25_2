package ru.rad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rad.entity.Products;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query(value = "select * from products where user_id = :userId order by id", nativeQuery = true)
    Optional<List<Products>> findProductsByUserId(@Param(value = "userId") Long userId);
}
