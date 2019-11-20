package com.bjsxt.pojo;

import java.util.Objects;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public class User {
    private int uid;
    private String uname;
    private String pwd;

    public User() {
    }

    public User(int uid, String uname, String pwd) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid() &&
                getUname().equals(user.getUname()) &&
                getPwd().equals(user.getPwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUname(), getPwd());
    }
}
