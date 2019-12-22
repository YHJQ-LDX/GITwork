package com.yhjqsw.wm.admin.model;

public class UserPassword {
    private String oldpassword;
    private String newpassword;
    private String checkpassword;

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    private String username;


    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getCheckpassword() {
        return checkpassword;
    }

    public void setCheckpassword(String checkpassword) {
        this.checkpassword = checkpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
