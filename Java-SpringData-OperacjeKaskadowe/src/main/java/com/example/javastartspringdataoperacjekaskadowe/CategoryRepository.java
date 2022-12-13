package com.example.javastartspringdataoperacjekaskadowe;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    @Query("SELECT AVG(a.buyNowPrice) FROM Category c JOIN c.auctions a WHERE c.id = :categoryId")
    Optional<Double> getAvgPriceForCategory(long categoryId);
}
