package vn.bang.WebBanHang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.bang.WebBanHang.common.Gender;
import vn.bang.WebBanHang.controller.request.UserCreationRequest;
import vn.bang.WebBanHang.controller.request.UserPasswordRequest;
import vn.bang.WebBanHang.controller.request.UserUpdateRequest;
import vn.bang.WebBanHang.controller.response.UserPageResponse;
import vn.bang.WebBanHang.controller.response.UserResponse;
import vn.bang.WebBanHang.service.UserService;

import java.util.*;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller")
@Slf4j(topic = "USER-CONTROLLER")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user list", description = "API retries user from db")
    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) String sort,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "20") int size){
        log.info("Get user list");

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message","user list");
        result.put("data",userService.findAll(keyword,sort,page,size));

        return result;
    }

    @Operation(summary = "Get user detail", description = "API retries user from db")
    @GetMapping("/{userid}")
    public Map<String,Object> getUserDetail(@PathVariable @Min(1) Long userId){
        log.info("Get user detail by ID: {}", userId);

        userService.findById(userId);

//        UserResponse userDetail = new UserResponse();
//        userDetail.setId(1l);
//        userDetail.setUserName("admin");
//        userDetail.setFirstName("Java");
//        userDetail.setLastName("Tay");
//        userDetail.setBirthDay(new Date());
//        userDetail.setGender(Gender.MALE);
//        userDetail.setPhone("0987654321");
//        userDetail.setEmail("abc@gmail.com");

        Map<String,Object> result = new LinkedHashMap<>();
        result.put("Status",HttpStatus.OK.value());
        result.put("Mesage","user");
        result.put("Data",null);
        return result;
    }

    @Operation(summary = "Create user", description = "API retries user from db")
    @PostMapping("/add")
    public ResponseEntity<Object> createUser(@RequestBody UserCreationRequest request) {
        log.info("Create user: {}", request);
        Map<String,Object> result = new LinkedHashMap<>();

        result.put("Status", HttpStatus.CREATED.value());
        result.put("Message", "User created successfully");
        result.put("Data", userService.save(request));


        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @Operation(summary = "Update user", description = "API retries user from db")
    @PutMapping("/upd")
    public Map<String,Object> updateUser(@RequestBody UserUpdateRequest request) {
        log.info("Updating user: {}", request);

        userService.update(request);

        Map<String,Object> result = new LinkedHashMap<>();
        result.put("Status", HttpStatus.OK.value());
        result.put("Message", "User updated successfully");
        result.put("Data", " ");

        return result;
    }

    @Operation(summary = "Change Password", description = "API retries user from db")
    @PatchMapping("/change-pwd")
    public Map<String,Object> changePassword(UserPasswordRequest request) {
        log.info("Changing password for user: {}", request);

        userService.changePassword(request);

        Map<String,Object> result = new LinkedHashMap<>();

        result.put("Status", HttpStatus.NO_CONTENT.value());
        result.put("Message", "Password updated successfully");
        result.put("Data", " ");

        return result;
    }

    @Operation(summary = "Delete User", description = "API retries user from db")
    @PatchMapping("/del/{userid}")
    public Map<String,Object> deleteUser(@PathVariable @Min(1) Long userId) {
        log.info("Deleting user: {}", userId);

        userService.delete(userId);

        Map<String,Object> result = new LinkedHashMap<>();
        result.put("Status", HttpStatus.RESET_CONTENT.value());
        result.put("Message", "User deleted successfully");
        result.put("Data", " ");

        return result;
    }
}
