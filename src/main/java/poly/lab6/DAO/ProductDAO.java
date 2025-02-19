package poly.lab6.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.lab6.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
