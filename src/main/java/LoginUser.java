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
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
        WebElement loginusername = User.driver.findElement(By.id("UserName"));
        WebElement loginpassword = User.driver.findElement(By.id("Password"));
        WebElement submit = User.driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[4]/td[2]/input"));
        loginusername.sendKeys(loginuser.loginusername);
        loginpassword.sendKeys(loginuser.loginpassword);
        submit.click();
        return checkLogisFromStatus();
    }
    public static boolean checkLogisFromStatus() {
        boolean output = true;

        if(!User.driver.findElements(By.id("header-container-search")).isEmpty()){
            return true;
        }
        List<WebElement> usernameError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> passwordError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[3]/td[2]/span"));
        List<WebElement> bothError = User.driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[5]/td/div/ul/li"));
        if (!usernameError.get(0).getText().contains("https://elenta.lt")) {
            System.out.println(usernameError.get(0).getText());
            output = false;
        }
        if (!passwordError.get(0).getText().contains("https://elenta.lt")) {
            System.out.println(passwordError.get(0).getText());
            output = false;
        }
        if (!bothError.get(0).getText().contains("https://elenta.lt")) {
            System.out.println(bothError.get(0).getText());
            output = false;
        }
        return output;
    }
}
