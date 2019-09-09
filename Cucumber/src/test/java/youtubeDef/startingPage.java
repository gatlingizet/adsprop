package youtubeDef;


import com.codeborne.selenide.Configuration;
import cucumber.api.PendingException;
import cucumber.api.java.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.xpath;
import static youtubeDef.testDefs.getDataProperties;


public class startingPage {

    @After
    public void closeOnFail() {
        try {
            closeBrowser();
        } catch (Exception e) {
            throw new AssertionError("A clear description of the failure", e);
        }
    }

    private void closeBrowser() {
        close();
    }


    @Given("^browser with opened YouTube site")
    public void browserWithOpenedYouTubeSiteByLink() throws Throwable {
        Configuration.headless = Boolean.parseBoolean(getDataProperties("headless"));
        open(getDataProperties("link"));

    }

    @When("^click to login button$")
    public void clickToLoginButton() {
        $("#buttons > ytd-button-renderer > a").click();
    }

    @Then("^can see google form with login name$")
    public void canSeeGoogleFormWithLoginName() {


    }

    @Then("^can see google form with login name and text \"([^\"]*)\"$")
    public void canSeeGoogleFormWithLoginNameAndText(String arg0) {
        $(By.xpath("//*[@class='AxOyFc snByac']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@class='AxOyFc snByac']")).shouldHave(text(arg0));
    }
}
