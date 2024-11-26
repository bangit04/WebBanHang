package vn.bang.WebBanHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.bang.WebBanHang.model.UserEntity;

public interface UserRepository extends JpaRepository<Long, UserEntity> {
}
