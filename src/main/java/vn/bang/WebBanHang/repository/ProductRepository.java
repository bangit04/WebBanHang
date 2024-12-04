package vn.bang.WebBanHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bang.WebBanHang.model.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
