package stepDefs;

import Pages.MainPage;
import Pages.MyAccountPage;
import Pages.SingInPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static DriverFactory.LocalDriverFactory.closeDriver;
import static DriverFactory.LocalDriverFactory.getDriver;
import static helpers.PropertiesFileReader.getSystemPropertyByName;
import static org.junit.Assert.assertTrue;

@Slf4j
public class Steps {

    private MainPage mainPage = new MainPage(getDriver());
    private SingInPage loginPage = new SingInPage(getDriver());
    private MyAccountPage accountPage = new MyAccountPage(getDriver());


    @After("@UI")
    public void tearDown() {
        closeDriver();
    }

    @Given("user opens main {string} of Wikipedia")
    public void userIsOnThe_LiteCart_Home_Page(String url) {
        getDriver().get(getSystemPropertyByName(url));
    }

    @When("click Sign in button")
    public void clickSignInButton() {
        mainPage.getLogIn().click();
    }

    @And("fill in {string} and {string}")
    public void fillInCredentals(String mail, String password) {
        loginPage.fillInputFieldByName(getSystemPropertyByName(mail), getSystemPropertyByName(password));
    }

    @Then("check logged in {string}")
    public void checkLoggedInUser(String userName) {
        String user = accountPage.getUserName();
        assertTrue("User is not logged in or has wrong userName", user.equals(getSystemPropertyByName(userName)));
    }

    @When("click Sing out button")
    public void clickSingOutButton() {
        mainPage.getLogOut().click();
    }

    @Then("check that user successfuly logged out")
    public void checkThatUserLoggedOutSuccessfuly() {
        assertTrue("User is still logged in!", mainPage.getLogIn().isDisplayed());
    }

    @When("log out by link")
    public void logOutByLink() {
        String url = getSystemPropertyByName("URL");
        String logOutLink = getSystemPropertyByName("logOutLink");
        mainPage.logOutByLink(url, logOutLink, getDriver());
    }
}
