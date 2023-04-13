package lab9lab10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab9lab10.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
