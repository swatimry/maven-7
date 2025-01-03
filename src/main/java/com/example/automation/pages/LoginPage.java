import com.example.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginAutomationTest {
    @Test
    void testLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://the-internet.herokuapp.com/login");

            // Use LoginPage methods
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("tomsmith");
            loginPage.setPassword("SuperSecretPassword!");
            loginPage.clickLogin();

            // Validate successful login
            String successMessage = loginPage.getSuccessMessage();
            assertTrue(successMessage.contains("You logged into a secure area!"), "Login success message not found");
        } finally {
            driver.quit();
        }
    }
}
