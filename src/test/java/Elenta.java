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
public class Elenta {
    @Test
    public void loginCorrectTest(){
        assertTrue(LoginUser.login( new LoginUser("Kupiskis", "123456")));
    }
    @Test
    public void loginWithSpaceUsernameEndTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupiskis ", "123456")));
    }
    @Test
    public void loginWithDotUsernameFrontTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupi.skis", "123456")));
    }
    @Test
    public void loginEmptyPasswordTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", "")));
    }
    @Test
    public void loginWithSpaceInsteadOfPasswordTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", " ")));
    }
    @Test
    public void loginWithSpaceUsernameFrontTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", " 123456")));
    }
    @Test
    public void loginWithSpaceUsername2EndTest(){
        assertFalse(LoginUser.login( new LoginUser(" Kupiskis", "123456 ")));
    }
    @Test
    public void loginWithIncorrectPasswordFrontTest(){
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
    public void loginWithRandomSymbolsInnameEndTest(){
        assertFalse(LoginUser.login( new LoginUser("Kupiskis!@@#$%%^", "123456")));
    }
    @Test
    public void loginEmptyUsernameTest(){
        assertFalse(LoginUser.login( new LoginUser("", "123456")));
    }
    @Test
    public void registerUserTest(){
        assertTrue(User.registerUser( new User("Kupiskis","Kupiskis19@inbox.lt","123456","123456")));
    }
    @Test
    public void registerNoUsernameTest(){
        assertFalse(User.registerUser( new User("","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registerSpaceInFrontUsernameTest(){
        assertFalse(User.registerUser( new User(" Kalvarija","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registerSpaceAfterNameTest(){
        assertFalse(User.registerUser( new User("Kalvarija ","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registeroneNumberUsername(){
        assertFalse(User.registerUser( new User("1","Saimisss@hotmail.com","123456","123456")));
    }
    @Test
    public void registeruserNameWithSpaceInMiddleTest(){
        assertFalse(User.registerUser( new User("Sai mis","Saimislll@hotmail.com","123456","123456")));
    }
    @Test
    public void registeremptyEmailTest(){
        assertFalse(User.registerUser( new User("Modzius","","123456","123456")));
    }
    @Test
    public void registerEmailWithSpaceInMiddleTest(){
        assertFalse(User.registerUser( new User("Modzius","Saim is@hotmail.com","123456","123456")));
    }
    @Test
    public void registerEmailWithoutDomainTest(){
        assertFalse(User.registerUser( new User("Saimis","Saimis.com","123456","123456")));
    }
    @Test
    public void registerEmailOneNumberUserTest(){
        assertFalse(User.registerUser( new User("Saimis","1","123456","123456")));
    }
    @Test
    public void registerEmailWithRandomsymbolsUserTest(){
        assertFalse(User.registerUser( new User("Saimis","!@#$%^&*()_+@hotmail","123456","123456")));
    }
    @Test
    public void registerPasswordOneSymbolTest(){
        assertFalse(User.registerUser( new User("Saimis","Saimis@hotmail","1","1")));
    }
    @Test
    public void registerPasswordWIthSpaceMiddleTest(){
        assertFalse(User.registerUser( new User("Saimis","Saimis@hotmail","123 456","123 456")));
    }
    @Test
    public void registerPasswordOnlySpaceTest(){
        assertFalse(User.registerUser( new User("Saimis","Saimis@hotmail"," "," ")));
    }
    @Test
    public void registerPasswordCapitalLettersNumbersTest(){
        assertTrue(User.registerUser( new User("Saimis","Saimis@hotmail","AGH1J23456","AGH1J23456")));
    }
    @Test
    public void registerPassword2EmptyTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","123456","")));
    }
    @Test
    public void registerPassword2OnlySpaceTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","123456"," ")));
    }
    @Test
    public void registerPassword2SpaceInMiddleTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","123456","123 56")));
    }
    @Test
    public void registerPassword2OneSymbolTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","123456","1")));
    }
    @Test
    public void registerPassword2RandomSymbolsTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","ČĘĘĖĮŠ","ČĘĘĖĮŠ")));
    }
    @Test
    public void registerPasswordMismatchTest(){
        assertFalse(User.registerUser( new User("Saulius","Saimis@hotmail.com","123456","ČĘĘĖĮŠ")));
    }
    @BeforeClass
    public void beforeClass() {
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
