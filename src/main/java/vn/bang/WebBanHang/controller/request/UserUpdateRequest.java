package vn.bang.WebBanHang.controller.request;

import vn.bang.WebBanHang.common.UserStatus;
import vn.bang.WebBanHang.common.UserType;

import java.io.Serializable;
import java.util.Date;

public class UserUpdateRequest implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String username;
    private String email;
    private String phone;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }
}
