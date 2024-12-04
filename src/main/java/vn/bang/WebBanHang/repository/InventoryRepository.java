package vn.bang.WebBanHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bang.WebBanHang.model.InventoryEntity;
@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
}
