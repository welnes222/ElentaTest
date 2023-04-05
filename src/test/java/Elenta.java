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

import static org.junit.Assert.assertTrue;

public class Elenta {
//    @Test
//    public void loadPageTest(){
//        User.driver.get("https://elenta.lt/registracija");
//    }
    @Test
    public void registerUserTest(){
        assertTrue(User.registerUser( new User("","lavonas@gmail.as","123456","123456")));
    }

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        User.driver.get("https://elenta.lt/registracija");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

    }
}
