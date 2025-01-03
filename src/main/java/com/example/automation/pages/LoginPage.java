package com.example.automation.pages;

public class LoginPage {
    private String username;
    private String password;
    private boolean isLoggedIn;

    public LoginPage() {
        this.isLoggedIn = false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void clickLogin() {
        if (username.equals("testuser") && password.equals("password123")) {
            isLoggedIn = true;
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
