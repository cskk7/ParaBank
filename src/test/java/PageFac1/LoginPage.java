package PageFac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    protected WebElement txtUsername;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    protected WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//button[@id='submit']")
    protected WebElement btnSubmit;


    public void launchURL(String strURL){

        driver.get(strURL);
    }
    public void enterUsername(String username){
        txtUsername.sendKeys(username);
        String userInput = txtUsername.getAttribute("value");
        Assert.assertEquals(userInput,"student");
//        Assert.assertTrue(listOfUserName.contains(userInput));
    }
    public void enterPassword(String passsword){
        txtPassword.sendKeys(passsword);
        String passwordInput = txtPassword.getAttribute("value");
        Assert.assertEquals(passwordInput,"Password123");
    }

    public void clickSubmit() {
        btnSubmit.click();
    }
}
