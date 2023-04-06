import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class CreateAd {
    public String adName;
    public String description;
    public String price;
    public String location;
    public String phoneNr;
    public String adEmail;

    public CreateAd(String adName, String description, String price, String location, String phoneNr, String adEmail) {
        this.adName = adName;
        this.description = description;
        this.price = price;
        this.location = location;
        this.phoneNr = phoneNr;
        this.adEmail = adEmail;
    }
    public static boolean creation(CreateAd createAd){
        User.driver.get("https://elenta.lt/patalpinti/pasirinkti-kategorija");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
        User.driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        User.driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[1]/a")).click();
        WebElement adName = User.driver.findElement(By.id("title"));
        WebElement description = User.driver.findElement(By.id("text"));
        WebElement price = User.driver.findElement(By.id("price"));
        WebElement location = User.driver.findElement(By.id("location-search-box"));
        WebElement phoneNr = User.driver.findElement(By.id("phone"));
        WebElement adEmail = User.driver.findElement(By.id("email"));
        adName.sendKeys(createAd.adName);
        description.sendKeys(createAd.description);
        price.sendKeys(createAd.price);
        location.sendKeys(createAd.location);
        phoneNr.sendKeys(createAd.phoneNr);
        adEmail.sendKeys(createAd.adEmail);
        User.driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
        User.driver.findElement(By.xpath("//*[@id=\"forward-button\"]")).click();
        User.driver.findElement(By.id("forward-button")).click();

        return true;
    }

}
