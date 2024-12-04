package vn.bang.WebBanHang.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import vn.bang.WebBanHang.common.Gender;
import vn.bang.WebBanHang.common.UserStatus;
import vn.bang.WebBanHang.common.UserType;

import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity{

    @Column(length = 255, name = "first_name")
    private String firstName;

    @Column(length = 255, name = "last_name")
    private String lastName;

    @Column(length = 255, name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length = 255, name = "email")
    private String email;

    @Column(length = 15, name = "phone")
    private String phone;

    @Column(length = 255, name = "username")
    private String username;

    @Column(length = 255, name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    //@JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(length = 255, name = "type")
    private UserType type;

    @Enumerated(EnumType.STRING)
    //@JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(length = 255, name = "status")
    private UserStatus status;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }


}
