package com.androiddev.blogger;

public class Users {
    private String Email;
    private String password;
    private String login;

    public Users(String email, String password, String login) {
        Email = email;
        this.password = password;
        this.login = login;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
