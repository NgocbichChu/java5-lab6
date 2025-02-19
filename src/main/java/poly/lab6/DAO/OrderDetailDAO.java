package poly.lab6.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.lab6.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}
