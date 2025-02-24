package poly.lab6.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.lab6.entity.Product;
import poly.lab6.entity.Report;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    // native queries - JPQL
    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    // Dùng DSL thay cho JPQL
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    // DSL
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT p.category AS group, SUM(p.price) AS sum, COUNT(p) AS count, SUM(p.price) / COUNT(p) AS average " +
            "FROM Product p " +
            "GROUP BY p.category " +
            "ORDER BY SUM(p.price) DESC")
    List<Report> getInventoryByCategory();


}
