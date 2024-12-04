package vn.bang.WebBanHang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.bang.WebBanHang.common.UserStatus;
import vn.bang.WebBanHang.controller.request.UserCreationRequest;
import vn.bang.WebBanHang.controller.request.UserPasswordRequest;
import vn.bang.WebBanHang.controller.request.UserUpdateRequest;
import vn.bang.WebBanHang.controller.response.UserPageResponse;
import vn.bang.WebBanHang.controller.response.UserResponse;
import vn.bang.WebBanHang.exception.ResourceNotFoundException;
import vn.bang.WebBanHang.model.AddressEntity;
import vn.bang.WebBanHang.model.UserEntity;
import vn.bang.WebBanHang.repository.AddressRepository;
import vn.bang.WebBanHang.repository.UserRepository;
import vn.bang.WebBanHang.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@Slf4j(topic = "USER-SERVICE")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserPageResponse findAll(String keyword, String sort, int page, int size) {
        log.info("findAll start");

        // sorting
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        if(StringUtils.hasLength(sort)){
            Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)"); // ten cot:asc|desc
            Matcher matcher = pattern.matcher(sort);
            if(matcher.find()){
                String columnName = matcher.group(1);
                if(matcher.group(3).equalsIgnoreCase("asc")){
                    order = new Sort.Order(Sort.Direction.ASC,columnName);
                } else {
                    order = new Sort.Order(Sort.Direction.DESC,columnName);
                }
            }
        }
        // xu ly truong hop fe
        int pageNo = 0;
        if(page > 0){
            pageNo = page - 1;
        }
        Pageable pageable = PageRequest.of(pageNo,size,Sort.by(order));
        Page<UserEntity> entityPage;

        if(StringUtils.hasLength(keyword)){
            entityPage = userRepository.searchByKeyword(keyword.toLowerCase(),pageable);
        } else {
            entityPage = userRepository.findAll(pageable);
        }

        return getUserPageResponse(page,size,entityPage);
        // page no
        // page size
        // list
    }


    @Override
    public List<UserResponse> findAll() {
        return List.of();
    }

    @Override
    public UserResponse findById(Long id) {
        log.info("Find user by id: {}",id);

        UserEntity userEntity = getUserEntity(id);


        return UserResponse.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .gender(userEntity.getGender())
                .birthday(userEntity.getBirthday())
                .username(userEntity.getUsername())
                .phone(userEntity.getPhone())
                .email(userEntity.getEmail())
                .build();
    }

    @Override
    public UserResponse findByUsername(String username) {
        return null;
    }

    @Override
    public UserResponse findByEmail(String email) {
        return null;
    }

    // Save User
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long save(UserCreationRequest req) {
        log.info("Saving user: {}",req);

        UserEntity user = new UserEntity();
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setGender(req.getGender());
        user.setBirthday(req.getBirthday());
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setType(req.getType());
        user.setStatus(UserStatus.NONE);
        userRepository.save(user);

        if(user.getId() != null){
            List<AddressEntity> addresses = new ArrayList<>();
            req.getAddress().forEach(addressRequest -> {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setApartmentNumber(addressRequest.getApartmentNumber());
                addressEntity.setFloor(addressRequest.getFloor());
                addressEntity.setBuilding(addressRequest.getFloor());
                addressEntity.setStreet_number(addressRequest.getStreet_number());
                addressEntity.setStreet(addressRequest.getStreet());
                addressEntity.setCity(addressRequest.getCity());
                addressEntity.setCountry(addressRequest.getCountry());
                addressEntity.setAddress_type(addressRequest.getAddress_type());
                addresses.add(addressEntity);
            });
            addressRepository.saveAll(addresses);
            log.info("Saved address: {}", addresses);
        }
        return user.getId();
    }


    // Update User
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserUpdateRequest req) {
        log.info("Updating user: {}",req);
        // get user by id
        UserEntity user = getUserEntity(req.getId());
        // set data
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setGender(req.getGender());
        user.setBirthday(req.getBirthday());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setUsername(req.getUsername());

        userRepository.save(user);
        log.info("Update user: {}", user);


        List<AddressEntity> addresses = new ArrayList<>();


        req.getAddress().forEach(address -> {
            AddressEntity addressEntity = addressRepository.findByUserIdAndAddressType(user.getId(), address.getAddress_type());
            if(addressEntity == null){
                addressEntity = new AddressEntity();
            }
            addressEntity.setApartmentNumber(address.getApartmentNumber());
            addressEntity.setFloor(address.getFloor());
            addressEntity.setBuilding(address.getFloor());
            addressEntity.setStreet_number(address.getStreet_number());
            addressEntity.setStreet(address.getStreet());
            addressEntity.setCity(address.getCity());
            addressEntity.setCountry(address.getCountry());
            addressEntity.setAddress_type(address.getAddress_type());
            addressEntity.setId(user.getId());

            addresses.add(addressEntity);
        });


        //save address
        addressRepository.saveAll(addresses);
        log.info("Updated addresses: {}",addresses);
        // save to database
    }

    @Override
    public void changePassword(UserPasswordRequest req) {
        log.info("Changing password for user: {}", req);


        UserEntity user = getUserEntity(req.getId());
        if(req.getPassword().equals(req.getConfirmPassword())){
            user.setPassword(passwordEncoder.encode(req.getPassword()));
        }

        userRepository.save(user);
        log.info("Changed password for user: {}",user);
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting user: {}", id);


        UserEntity user = getUserEntity(id);
        user.setStatus(UserStatus.INACTIVE);

        userRepository.save(user);
        log.info("Delete user: {}", id);
    }

    private UserEntity getUserEntity(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    private static UserPageResponse getUserPageResponse(int page, int size, Page<UserEntity> userEntities) {
        log.info("Convert User Entity Page");

        List<UserResponse> userList = userEntities.stream().map(
                entity -> UserResponse.builder()
                        .id(entity.getId())
                        .firstname(entity.getFirstName())
                        .lastname(entity.getLastName())
                        .gender(entity.getGender())
                        .birthday(entity.getBirthday())
                        .username(entity.getUsername())
                        .phone(entity.getPhone())
                        .email(entity.getEmail())
                        .build()
        ).toList();

        UserPageResponse response = new UserPageResponse();
        response.setPageNumber(page);
        response.setPageSize(size);
        response.setTotalElements(userEntities.getTotalElements());
        response.setTotalPages(userEntities.getTotalPages());
        response.setUsers(userList);

        return response;
    }
}
