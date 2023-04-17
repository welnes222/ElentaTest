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
//        RegisterUser.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
//        WebElement adName = RegisterUser.driver.findElement(By.id("title"));
//        WebElement description = RegisterUser.driver.findElement(By.id("text"));
//        WebElement price = RegisterUser.driver.findElement(By.id("price"));
//        WebElement location = RegisterUser.driver.findElement(By.id("location-search-box"));
//        WebElement phoneNr = RegisterUser.driver.findElement(By.id("phone"));
//        WebElement adEmail = RegisterUser.driver.findElement(By.id("email"));
//        adName.sendKeys(createAd.adName);
//        description.sendKeys(createAd.description);
//        price.sendKeys(createAd.price);
//        location.sendKeys(createAd.location);
//        phoneNr.sendKeys(createAd.phoneNr);
//        adEmail.sendKeys(createAd.adEmail);
//        RegisterUser.driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
//        RegisterUser.driver.findElement(By.xpath("//*[@id=\"forward-button\"]")).click();
//        RegisterUser.driver.findElement(By.id("forward-button")).click();
//        return checkIfAdWasUploaded();
        return true;
    }
    public static void adCreationPage1(CreateAd createAd){
        RegisterUser.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_Antikvariatas&actionId=Siulo&returnurl=%2Fskelbimai%2Fbuitis-laisvalaikis%2Fantikvariatas");
        WebElement adName = RegisterUser.driver.findElement(By.id("title"));
        WebElement description = RegisterUser.driver.findElement(By.id("text"));
        WebElement price = RegisterUser.driver.findElement(By.id("price"));
        WebElement location = RegisterUser.driver.findElement(By.id("location-search-box"));
        location.clear();
        WebElement phoneNr = RegisterUser.driver.findElement(By.id("phone"));
        phoneNr.clear();
        WebElement adEmail = RegisterUser.driver.findElement(By.id("email"));
        adEmail.clear();

        adName.sendKeys(createAd.adName);
        description.sendKeys(createAd.description);
        price.sendKeys(createAd.price);
        location.sendKeys(createAd.location);
        phoneNr.sendKeys(createAd.phoneNr);
        adEmail.sendKeys(createAd.adEmail);
        RegisterUser.driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
    }
    public static void adCreationPage2(CreateAd createAd){
        String filePath = "C:\\Users\\Rokas\\IdeaProjects\\ElentaTest\\src\\main\\resources\\Photo\\MD_486051_p1.JPG";
        RegisterUser.driver.findElement(By.id("inputfile")).sendKeys(filePath);
        RegisterUser.driver.findElement(By.xpath("//*[@id=\"forward-button\"]")).click();
    }
    public static void adCreationPage3(CreateAd createAd){
        RegisterUser.driver.findElement(By.id("forward-button")).click();
    }
    public static boolean adCreation(CreateAd createAd){
        adCreationPage1(createAd);
        if(!validateAd1stPage()){
            return false;
        }
        adCreationPage2(createAd);
        if(!validateAd2ndPage()){
            return false;
        }
        adCreationPage3(createAd);
        if(!validateAd3rdPage()){
            return false;
        }
        return true;
    }
    public static boolean validateAd2ndPage(){
        return true;
    }
    public static boolean validateAd3rdPage(){
        return true;
    }
    public static boolean validateAd1stPage(){
        boolean output = true;

        if(!RegisterUser.driver.findElements(By.id("unit-1041268h")).isEmpty()){
            return true;
        }
        List<WebElement> usernameErrorAd = RegisterUser.driver.findElements(By.id("te"));
        List<WebElement> passwordErrorAd = RegisterUser.driver.findElements(By.id("txte"));
        List<WebElement> phoneErrorAd = RegisterUser.driver.findElements(By.id("pe"));
        List<WebElement> phoneErrorAd2 = RegisterUser.driver.findElements(By.id("ce"));
        if (usernameErrorAd.size() > 0) {
            System.out.println(usernameErrorAd.get(0).getText());
            output = false;
        }
        if (passwordErrorAd.size() > 0) {
            System.out.println(passwordErrorAd.get(0).getText());
            output = false;
        }
        if (phoneErrorAd.size() > 0) {
            System.out.println(phoneErrorAd.get(0).getText());
            output = false;
        }
        if (phoneErrorAd2.size() > 0) {
            System.out.println(phoneErrorAd2.get(0).getText());
            output = false;
        }
        return output;
    }
}
