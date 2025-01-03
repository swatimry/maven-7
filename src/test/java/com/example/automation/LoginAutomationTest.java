package com.example.automation.tests;

import com.example.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoginPageTest {

    @Test
    void testLoginPageMethods() {
        // Mock WebDriver and WebElement for unit testing
        WebDriver mockDriver = mock(WebDriver.class);
        WebElement mockElement = mock(WebElement.class);

        // Stub methods to return mock elements
        when(mockDriver.findElement(By.id("username"))).thenReturn(mockElement);
        when(mockDriver.findElement(By.id("password"))).thenReturn(mockElement);
        when(mockDriver.findElement(By.cssSelector("button[type='submit']"))).thenReturn(mockElement);
        when(mockDriver.findElement(By.cssSelector("div.flash.success"))).thenReturn(mockElement);

        // Stub the getText method for success message
        when(mockElement.getText()).thenReturn("You logged into a secure area!");

        // Instantiate LoginPage with the mocked WebDriver
        LoginPage loginPage = new LoginPage(mockDriver);

        // Test setUsername
        loginPage.setUsername("testuser");
        verify(mockElement).sendKeys("testuser");

        // Test setPassword
        loginPage.setPassword("password123");
        verify(mockElement).sendKeys("password123");

        // Test clickLogin
        loginPage.clickLogin();
        verify(mockElement).click();

        // Test getSuccessMessage
        String successMessage = loginPage.getSuccessMessage();
        assertEquals("You logged into a secure area!", successMessage);
    }
}
