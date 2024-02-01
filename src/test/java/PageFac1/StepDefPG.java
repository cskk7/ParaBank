package PageFac1;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepDefPG {
    static WebDriver driver;
    static LoginPage loginPage;

    static LogoutPage logoutPage;

    @Before
    public void ScenarioName(Scenario scenario){
        driver  = DriverFactory.getDriver();
        System.out.println("---> scenario: "+scenario.getName());
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Given("user on loginpage")
    public void userOnLoginpage() {
        loginPage.launchURL("https://practicetestautomation.com/practice-test-login/");
    }

    @When("user enetered username")
    public void userEneteredUsername() {
        loginPage.enterUsername("student");
    }

    @And("user entered password")
    public void userEnteredPassword() {
        loginPage.enterPassword("Password123");
    }

    @And("user clicked submit")
    public void userClickedSubmit() {
        loginPage.clickSubmit();
    }

    @Then("user login successfully")
    public void userLoginSuccessfully() throws IOException {
        String actual = driver.findElement(By.className("post-content")).getText();
//        String expected = "Congratulations student. You successfully logged in!\n" +
//                "Log out";
//        Assert.assertEquals(actual,expected);
    }


    @Given("user on homepage")
    public void userOnHomepage() {
        String actual = driver.getTitle();
        String expected = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(actual,expected);
    }

    @When("user clicked logout")
    public void userClickedLogout() {
       logoutPage.clickSubmit();
    }

    @Then("user logout successfully")
    public void userLogoutSuccessfully() {
        String actual = driver.getTitle();
        String expected = "Test Login | Practice Test Automation";
        Assert.assertEquals(actual,expected);
    }
    @AfterStep
    public void attach(Scenario scenario)throws Throwable {
            final byte[] screenshotTaken = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotTaken, "image/png", "Screenshot");

//        scenario.attach(getByteScreenshot(), "image/png", scenario.getName());
    }
//    public static byte[] getByteScreenshot() throws IOException
//    {
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        byte[] fileContent = FileUtils.readFileToByteArray(src);
//        return fileContent;
//    }
    @After
    public void cleanUp(Scenario scenario) throws IOException {

        scenario.log("---> scenario: "+scenario.getStatus());


        if(scenario.getName().equals("PTA-logout")){
            driver.close();
        }

//        TakesScreenshot tk = (TakesScreenshot) driver;
//        scenario.attach(tk.getScreenshotAs(OutputType.BYTES),"image/png","Screenshot");
    }
//    @AfterAll
//    public void quit(){
//        driver.quit();
//    }
}
