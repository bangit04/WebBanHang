package vn.bang.WebBanHang.controller.request;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class UserPasswordRequest implements Serializable {
    private Long id;
    private String password;
    private String confirmPassword;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
