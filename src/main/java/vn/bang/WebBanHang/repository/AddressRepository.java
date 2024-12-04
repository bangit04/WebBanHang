package vn.bang.WebBanHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bang.WebBanHang.model.AddressEntity;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    AddressEntity findByUserIdAndAddressType(Long userId, Integer addressType);
}
