package PageFac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    public WebDriver driver;
    public LogoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Log out']")
    protected WebElement btnLogout;

    public void clickSubmit() {
        btnLogout.click();
    }
}
