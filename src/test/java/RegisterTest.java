import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class RegisterTest {

    @Test
    public void registerUserTest(){
        assertTrue(RegisterUser.registerUser( new RegisterUser("karalius dzeimsas","kontautas222@inbox.lt","123456","123456")));
    }
    @Test
    public void registerNoUsernameTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registerSpaceInFrontUsernameTest(){
        assertTrue(RegisterUser.registerUser( new RegisterUser(" Kalvarija","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registerSpaceAfterNameTest(){
        assertTrue(RegisterUser.registerUser( new RegisterUser("Kalvarija ","Saimis@hotmail.com","123456","123456")));
    }
    @Test
    public void registerOneNumberUsername(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("7","Saimsasasasisss@hotmail.com","123456","123456")));
    }
    @Test
    public void registerOnlyDollarsUsername(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("$$$$$$$$$","Saimisss@hotmail.com","123456","123456")));
    }
    @Test
    public void registerUserNameWithSpaceInMiddleTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Sai mis","Saimislll@hotmail.com","123456","123456")));
    }
    @Test
    public void registerEmptyEmailTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Modzius","","123456","123456")));
    }
    @Test
    public void registerEmailWithSpaceInMiddleTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Modzius","Saim is@hotmail.com","123456","123456")));
    }
    @Test
    public void registerEmailWithoutDomainTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","Saimisss","123456","123456")));
    }
    @Test
    public void registerEmailOneNumberUserTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","1","123456","123456")));
    }
    @Test
    public void registerEmailWithRandomsymbolsUserTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","!@#$%^&*()_+@hotmail","123456","123456")));
    }
    @Test
    public void registerPasswordOneSymbolTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","Saimis@hotmail","1","1")));
    }
    @Test
    public void registerPasswordWIthSpaceMiddleTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","Saimis@hotmail","123 456","123 456")));
    }
    @Test
    public void registerPasswordOnlySpaceTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saimis","Saimis@hotmail"," "," ")));
    }
    @Test
    public void registerPasswordCapitalLettersNumbersTest(){
        assertTrue(RegisterUser.registerUser( new RegisterUser("Saimis","Saimis@hotmail","AGH1J23456","AGH1J23456")));
    }
    @Test
    public void registerPassword2EmptyTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","123456","")));
    }
    @Test
    public void registerPassword2OnlySpaceTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","123456"," ")));
    }
    @Test
    public void registerPassword2SpaceInMiddleTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","123456","123 56")));
    }
    @Test
    public void registerPassword2OneSymbolTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","123456","1")));
    }
    @Test
    public void registerPassword2RandomSymbolsTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","ČĘĘĖĮŠ","!@#$%^&*()_")));
    }
    @Test
    public void registerPasswordMismatchTest(){
        assertFalse(RegisterUser.registerUser( new RegisterUser("Saulius","Saimis@hotmail.com","123456","ČĘĘĖĮŠ")));
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
