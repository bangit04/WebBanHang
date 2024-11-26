package vn.bang.WebBanHang.service;

import vn.bang.WebBanHang.controller.request.UserCreationRequest;
import vn.bang.WebBanHang.controller.request.UserPasswordRequest;
import vn.bang.WebBanHang.controller.request.UserUpdateRequest;
import vn.bang.WebBanHang.controller.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse findByUsername(String username);

    UserResponse findByEmail(String email);

    long save(UserCreationRequest request);

    void update(UserUpdateRequest request);

    void changePassword(UserPasswordRequest request);

    void delete(Long id);
}
