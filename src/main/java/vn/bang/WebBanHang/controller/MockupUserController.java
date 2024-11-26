package vn.bang.WebBanHang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.bang.WebBanHang.controller.request.UserCreationRequest;
import vn.bang.WebBanHang.controller.request.UserPasswordRequest;
import vn.bang.WebBanHang.controller.request.UserUpdateRequest;
import vn.bang.WebBanHang.controller.response.UserResponse;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mockup/user")
@Tag(name = "Mockup User Controller")
public class MockupUserController {
    @Operation(summary = "Get user list", description = "API retries user from db")
    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(required = false) String keyword,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "20") int size){

        UserResponse userResponse1 = new UserResponse();
        userResponse1.setId(1l);
        userResponse1.setUserName("admin");
        userResponse1.setFirstName("Java");
        userResponse1.setLastName("Tay");
        userResponse1.setBirthDay(new Date());
        userResponse1.setGender("");
        userResponse1.setPhone("0987654321");
        userResponse1.setEmail("abc@gmail.com");
        UserResponse userResponse2 = new UserResponse();
        userResponse2.setId(2l);
        userResponse2.setUserName("user");
        userResponse2.setFirstName("Leo");
        userResponse2.setLastName("Messi");
        userResponse2.setBirthDay(new Date());
        userResponse2.setGender("");
        userResponse2.setPhone("091234567");
        userResponse2.setEmail("xyz@gmail.com");
        List<UserResponse> userList = List.of(userResponse1,userResponse2);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message","user list");
        result.put("data",userList);

        return result;
    }

    @Operation(summary = "Get user detail", description = "API retries user from db")
    @GetMapping("/{userid}")
    public Map<String,Object> getUserDetail(@PathVariable @Min(1) Long userId){
        UserResponse userDetail = new UserResponse();
        userDetail.setId(1l);
        userDetail.setUserName("admin");
        userDetail.setFirstName("Java");
        userDetail.setLastName("Tay");
        userDetail.setBirthDay(new Date());
        userDetail.setGender("");
        userDetail.setPhone("0987654321");
        userDetail.setEmail("abc@gmail.com");

        Map<String,Object> result = new LinkedHashMap<>();
        result.put("Status",HttpStatus.OK.value());
        result.put("Mesage","user");
        result.put("Data",userDetail);
        return result;
    }

    @Operation(summary = "Create user", description = "API retries user from db")
    @PostMapping("/add")
    public ResponseEntity<Long> createUser(UserCreationRequest request) {
//        Map<String,Object> result = new LinkedHashMap<>();
//
//        result.put("Status", HttpStatus.OK.value());
//        result.put("Message", "User created successfully");
//        result.put("Data", 3);

        return new ResponseEntity<>(1l,HttpStatus.CREATED);
    }

    @Operation(summary = "Update user", description = "API retries user from db")
    @PutMapping("/upd")
    public Map<String,Object> updateUser(UserUpdateRequest request) {
        Map<String,Object> result = new LinkedHashMap<>();

        result.put("Status", HttpStatus.OK.value());
        result.put("Message", "User updated successfully");
        result.put("Data", " ");

        return result;
    }

    @Operation(summary = "Change Password", description = "API retries user from db")
    @PatchMapping("/change-pwd")
    public Map<String,Object> changePassword(UserPasswordRequest request) {
        Map<String,Object> result = new LinkedHashMap<>();

        result.put("Status", HttpStatus.NO_CONTENT.value());
        result.put("Message", "Password updated successfully");
        result.put("Data", " ");

        return result;
    }

    @Operation(summary = "Delete User", description = "API retries user from db")
    @PatchMapping("/{userid}/del")
    public Map<String,Object> deleteUser(@PathVariable @Min(1) Long id) {
        Map<String,Object> result = new LinkedHashMap<>();

        result.put("Status", HttpStatus.RESET_CONTENT.value());
        result.put("Message", "User deleted successfully");
        result.put("Data", " ");

        return result;
    }
}
