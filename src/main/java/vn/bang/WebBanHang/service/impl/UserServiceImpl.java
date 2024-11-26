package vn.bang.WebBanHang.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.bang.WebBanHang.common.UserStatus;
import vn.bang.WebBanHang.controller.request.UserCreationRequest;
import vn.bang.WebBanHang.controller.request.UserPasswordRequest;
import vn.bang.WebBanHang.controller.request.UserUpdateRequest;
import vn.bang.WebBanHang.controller.response.UserResponse;
import vn.bang.WebBanHang.model.UserEntity;
import vn.bang.WebBanHang.repository.UserRepository;
import vn.bang.WebBanHang.service.UserService;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@Slf4j(topic = "USERSERVICE")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        return List.of();
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Override
    public UserResponse findByUsername(String username) {
        return null;
    }

    @Override
    public UserResponse findByEmail(String email) {
        return null;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public long save(UserCreationRequest req) {
        log.info("Saving user: {}",req);
        UserEntity user = new UserEntity();
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setGender(req.getGender());
        user.setBirthday(req.getBirthday());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setType(req.getType());
        user.setStatus(UserStatus.NONE);
        userRepository.save(user);
        return 1;
    }

    @Override
    public void update(UserUpdateRequest request) {
        // get user by id

        // set data

        // save to database
    }

    @Override
    public void changePassword(UserPasswordRequest request) {

    }

    @Override
    public void delete(Long id) {

    }

    private UserEntity getUserEntity(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
