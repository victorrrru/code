package cn.interheart.api.user.web.bo;

import java.util.Date;

/**
 * Created by victorrrr on 2017/4/21.
 */
public class UserDto {

    private String username;
    private String password;
    private String gendar;
    private String telephone;
    private Date birthday;
    private String remark;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gendar='" + gendar + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", remark='" + remark + '\'' +
                '}';
    }
}
