package poly.lab6.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.lab6.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
}
