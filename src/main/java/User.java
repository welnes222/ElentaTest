import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class User {
    public String username;
    public String email;
    public String password;
    public String password2;
    public static WebDriver driver;

    public User(String username, String email, String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public static boolean registerUser(User user) {
        driver.get("https://elenta.lt/registracija");
        WebElement username = driver.findElement(By.id("UserName"));
        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement password2 = driver.findElement(By.id("Password2"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input"));
        username.sendKeys(user.username);
        email.sendKeys(user.email);
        password.sendKeys(user.password);
        password2.sendKeys(user.password2);
        submit.click();
        return true;
    }









}