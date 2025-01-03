package com.example.automation.tests;

import com.example.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAutomationTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("testuser");
        loginPage.setPassword("password123");
        loginPage.clickLogin();
        
        assertTrue(loginPage.isLoggedIn(), "Login should be successful for valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("invaliduser");
        loginPage.setPassword("wrongpassword");
        loginPage.clickLogin();
        
        assertFalse(loginPage.isLoggedIn(), "Login should fail for invalid credentials");
    }
}
