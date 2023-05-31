package org.teluskoMacbookContest.ProductSpringWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {
    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(String name, String type, String place);
    List<Product> findByPlaceIgnoreCase(String place);

    List<Product> findByWarrantyLessThan(int year);

    void deleteByName(String name);

}
