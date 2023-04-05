import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        return checkRegistrationFromStatus();
    }

    public static boolean checkRegistrationFromStatus(){
        boolean output = true;

        if(!driver.findElements(By.className("info")).isEmpty()){
//            logout();
            return true;
        }
        List<WebElement> loginError = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
//        List<WebElement> validLogin = driver.findElements(By.xpath("//*[@id=\"loginRegisterRoot\"]/div/div[2]/div/form/div[1]/div/div"));
        if (!loginError.get(0).getText().contains("https://elenta.lt")){
            System.out.println(loginError.get(0).getText());
            output = false;
        }
//        List<WebElement> emailError = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span"));
//        if (!emailError.get(0).getText().contains("https://elenta.lt")) {
//            System.out.println(emailError.get(0).getText());
//            output = false;
//        }







        return output;
    }

//        if (!validLogin.isEmpty()){
//            System.out.println(validLogin.get(0).getText());
//            output = false;
//        }
//    public static void logout(){
//        driver.get("https://www.mohito.com/lt/lt/customer/account/logout/");
//    }

}