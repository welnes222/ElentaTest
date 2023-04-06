import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class LoginUser {
    public String loginusername;
    public String loginpassword;
    public LoginUser(String loginusername, String loginpassword) {
        this.loginusername = loginusername;
        this.loginpassword = loginpassword;
    }
    public static boolean login(LoginUser loginuser) {
        User.driver.get("https://elenta.lt/prisijungti");
        WebElement loginusername = User.driver.findElement(By.id("UserName"));
        WebElement loginpassword = User.driver.findElement(By.id("Password"));
        WebElement submit = User.driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[4]/td[2]/input"));
        loginusername.sendKeys(loginuser.loginusername);
        loginpassword.sendKeys(loginuser.loginpassword);
        submit.click();
        return checkLoginFormStatus();
    }
    public static boolean checkLoginFormStatus() {
        boolean output = true;

        if(!User.driver.findElements(By.id("header-container-search")).isEmpty()){
            User.driver.get("https://elenta.lt/accounts/logout");
            return true;
        }
        List<WebElement> usernameError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> passwordError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[3]/td[2]/span"));
        List<WebElement> bothError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[5]/td/div/ul/li"));
        if (usernameError.size() > 0) {
            System.out.println(usernameError.get(0).getText());
            output = false;
        }
        if (passwordError.size() > 0) {
            System.out.println(passwordError.get(0).getText());
            output = false;
        }
        if (bothError.size() > 0) {
            System.out.println(bothError.get(0).getText());
            output = false;
        }
        return output;
    }
}
