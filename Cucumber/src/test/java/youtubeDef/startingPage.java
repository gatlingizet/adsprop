package youtubeDef;


import com.codeborne.selenide.Configuration;
import cucumber.api.PendingException;
import cucumber.api.java.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

    @When("^enter to search bar \"([^\"]*)\"$")
    public void enterToSearchBar(String arg0) throws Throwable {
        $(By.xpath("//*[@id='search']/form/div/div/input")).setValue(arg0);
    }

    @Then("^can see rows with \"([^\"]*)\" in dropdown list$")
    public void canSeeRowsWithInDropdownList(String arg0) throws Throwable {
        $(By.xpath("//*[@class='sbqs_c']")).shouldHave(text(arg0));
    }

    @When("^press Enter$")
    public void pressEnter() {
        $(By.xpath("//*[@id='search']/form/div/div/input")).sendKeys(Keys.ENTER);
    }

    @Then("^can see youTube Channel \"([^\"]*)\" in the top$")
    public void canSeeYouTubeChannelInTheTop(String arg0) throws Throwable {
        $$(By.xpath("//*[@id='channel-title']")).get(0).waitUntil(text(arg0),3000);
    }

    @Then("^can see page with text \"([^\"]*)\"$")
    public void canSeePageWithText(String arg0) throws Throwable {
        $(By.xpath("//*[@class='promo-title style-scope ytd-background-promo-renderer']")).waitUntil(text("No results found"),3000);
    }

    @Then("^can see start page$")
    public void canSeeStartPage() {
        $$(By.xpath("//*[@class='style-scope ytd-shelf-renderer']")).get(0).shouldHave(text("Trending"));
    }

    @When("^press \"([^\"]*)\" button$")
    public void pressButton(String arg0) throws Throwable {
        $(By.xpath("//*[@class='style-scope ytd-button-renderer style-destructive size-default']/yt-formatted-string")).waitUntil(text(arg0),5000);
        Thread.sleep(1000);
        $$(By.xpath("//*[@class='style-scope ytd-button-renderer style-destructive size-default']")).get(25).click();
    }
}
