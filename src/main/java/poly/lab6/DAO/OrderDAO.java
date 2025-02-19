package poly.lab6.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.lab6.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
