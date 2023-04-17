import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class LoginTest {
    @Test
    public void loginCorrectTest(){
        assertTrue(LoginUser.login( new LoginUser("Kupiskis", "123456")));
    }
    @Test
    public void loginWithSpaceUsernameEndTest(){
        assertTrue(LoginUser.login( new LoginUser("Kupiskis ", "123456")));
    }
    @Test
    public void loginWithDotUsernameTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupi.skis", "123456")));
    }
    @Test
    public void loginEmptyPasswordTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupiskis", "")));
    }
    @Test
    public void loginWithSpaceInsteadOfPasswordTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupiskis", " ")));
    }
    @Test
    public void loginWithSpaceUsernameFrontTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", " 123456")));
    }
    @Test
    public void loginWithSpacePasswordEndTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", "123456 ")));
    }
    @Test
    public void loginWithIncorrectPasswordTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", "12138918adawd1aw8fwaf")));
    }
    @Test
    public void loginWithSpaceInMiddleUsernameTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupi skis ", "123456")));
    }
    @Test
    public void loginWithIncorrectUsernameTest(){
        assertFalse(LoginUser.login( new LoginUser("Neteisingasprisijungimas", "123456")));
    }
    @Test
    public void loginWithRandomSymbolsInNameEndTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupiskis!@@#$%%^", "123456")));
    }
    @Test
    public void loginEmptyUsernameTest(){
        assertFalse(LoginUser.login( new LoginUser("", "123456")));
    }
    @BeforeClass
    public void beforeClass() {
        RegisterUser.driver = new ChromeDriver();
        RegisterUser.driver.manage().window().maximize();
        RegisterUser.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        RegisterUser.driver.get("https://elenta.lt/prisijungti");
        RegisterUser.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }
}
