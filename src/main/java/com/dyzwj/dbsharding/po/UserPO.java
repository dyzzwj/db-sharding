package com.dyzwj.dbsharding.po;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName UserPO.java
 * @Description TODO
 * @createTime 2020年05月02日 19:09:00
 */
public class UserPO {

    private Long userId;
    private String fullname;
    private String userType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "userId=" + userId +
                ", fullname='" + fullname + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
