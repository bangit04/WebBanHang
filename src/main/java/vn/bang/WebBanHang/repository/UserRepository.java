package vn.bang.WebBanHang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.bang.WebBanHang.controller.response.UserResponse;
import vn.bang.WebBanHang.model.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("select u from UserEntity u where u.status = 'ACTIVE' " +
            "and (lower(u.firstName) like concat('%', :keyword, '%'), '%') " +
            "or lower(u.lastName) like concat('%', :keyword, '%'), '%') " +
            "or lower(u.username) like concat('%', :keyword, '%') " +
            "or lower(u.phone) like concat('%', :keyword, '%'), '%') " +
            "or lower(u.email) like concat('%', :keyword, '%'), '%'))")
    Page<UserEntity> searchByKeyword(String keyword);
}
