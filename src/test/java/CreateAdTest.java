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
public class CreateAdTest {
    @Test
    public void adCreate(){
        assertTrue(CreateAd.creation(new CreateAd("sulinio dangtis","be defektu, dangtis ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void noAdNameCreate(){
        assertFalse(CreateAd.creation(new CreateAd(" ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameNumbersCreate(){
        assertFalse(CreateAd.creation(new CreateAd("111111111111111 ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameNumbersWithDotCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Karnyzai. ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameNumbersWithMinusCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Karnyzai- ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameNumbersWithPlusCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Karnyzai+ ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameNumbersSpaceMiddleCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Karn yzai ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameSpaceInFrontCreate(){
        assertFalse(CreateAd.creation(new CreateAd(" Karnyzai","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameSpaceInEndCreate(){
        assertFalse(CreateAd.creation(new CreateAd("Karnyzai ","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameLongCreate(){
        assertFalse(CreateAd.creation(new CreateAd("Bepasikiskekopusteliavimoirankiaiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameDollarCreate(){
        assertFalse(CreateAd.creation(new CreateAd("$$$$$$$$","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNamePercentCreate(){
        assertFalse(CreateAd.creation(new CreateAd("%%%%%%%%%%","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameShoutSymbolCreate(){
        assertFalse(CreateAd.creation(new CreateAd("!!!!!!!!!!!!","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameStarCreate(){
        assertFalse(CreateAd.creation(new CreateAd("***********","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameRightSlashCreate(){
        assertFalse(CreateAd.creation(new CreateAd("///////////","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameLeftSlashCreate(){
        assertFalse(CreateAd.creation(new CreateAd("\\\\\\\\\\","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameCapsLockCreate(){
        assertTrue(CreateAd.creation(new CreateAd("KAPRONINIAI TINKLAI","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void adNameInArrayCreate(){
        assertTrue(CreateAd.creation(new CreateAd("[Expeliarmus burtas]","aaaaaaaaa ", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptionEmptyCreate(){
        assertFalse(CreateAd.creation(new CreateAd("Semkiu Lukstai","", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptionNumbersCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Semkiu Lukstai","111111111111111", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptionDotsCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Semkiu Lukstai","..........", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptionMaxSymbolsCreate(){
        assertFalse(CreateAd.creation(new CreateAd("Semkiu Lukstai","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptiionPlusCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Semkiu Lukstai","+++++", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void descriptionOneSymbolCreate(){
        assertTrue(CreateAd.creation(new CreateAd("Semkiu Lukstai","a", "43","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceLettersCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "aa","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceEmptyCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceDotCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "4.5","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceOnlyDotCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", ".","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceOnlySpaceCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", " ","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void pricePercentSymbolCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "%%%","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceSpaceInEndCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void priceManyNumbersCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111","Vilnius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationEmptyCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationOnlySpaceCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 "," ","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationOneLetterCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","a","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationOneNumbersCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","4564879","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationWithMinusCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","Vil-nius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationWithDotCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zuvies grybas","ka tik nuskintas", "79 ","Vil.nius","869871237","planktonas@gmail.com")));
    }
    @Test
    public void locationManySymbolsCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","869871237","planktonas@gmail.com")));
    }
    @Test
    public void phoneEmptyCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","","planktonas@gmail.com")));
    }
    @Test
    public void fourNumberCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","1111","planktonas@gmail.com")));
    }
    @Test
    public void twentyNumberCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","11111111111111111111","planktonas@gmail.com")));
    }
    @Test
    public void onlyLettersNumberCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","awwewrwfx","planktonas@gmail.com")));
    }
    @Test
    public void onlySpaceInMidllePhoneCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","8964713 47","planktonas@gmail.com")));
    }
    @Test
    public void dotPhoneCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","........","planktonas@gmail.com")));
    }
    @Test
    public void percentPhoneCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","%%%%%%%","planktonas@gmail.com")));
    }
    @Test
    public void emailEmptyCreate(){
        assertTrue(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284"," ")));
    }
    @Test
    public void numbersEmailCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284","11111111@gmail.com")));
    }
    @Test
    public void starEmailCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284","kamenkretys***@gmail.com")));
    }
    @Test
    public void halfEmailCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284","@gmail.com")));
    }
    @Test
    public void half2EmailCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284","Saimis")));
    }
    @Test
    public void spaceMiddleEmailCreate(){
        assertFalse(CreateAd.creation(new CreateAd("zencenio saknis","ka tik nuskintas", "79 ","Vilnius","869471284","kamenkr   etys@gmail.com")));
    }

    @BeforeClass
    public void beforeClass() {
        RegisterUser.driver = new ChromeDriver();
        RegisterUser.driver.manage().window().maximize();
        RegisterUser.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        RegisterUser.driver.get("https://elenta.lt/prisijungti");
        RegisterUser.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }
}
