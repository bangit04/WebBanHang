package vn.bang.WebBanHang.controller.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageResponse extends PageResponseAbstract implements Serializable {
    private List<UserResponse> users;

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
