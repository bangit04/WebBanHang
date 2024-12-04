package vn.bang.WebBanHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bang.WebBanHang.model.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
