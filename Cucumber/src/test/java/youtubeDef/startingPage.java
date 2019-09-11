package youtubeDef;


import com.codeborne.selenide.Configuration;
import cucumber.api.PendingException;
import cucumber.api.java.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        Configuration.headless = Boolean.parseBoolean(getDataProperties("headless"));
        open(getDataProperties("link"));

    }

    @When("^click to login button$")
    public void clickToLoginButton() {
        $("#buttons > ytd-button-renderer > a").click();
    }


    @Then("^can see google form with login name and text \"([^\"]*)\"$")
    public void canSeeGoogleFormWithLoginNameAndText(String arg0) {
        $(By.xpath("//*[@class='AxOyFc snByac']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@class='AxOyFc snByac']")).shouldHave(text(arg0));
    }

    @When("^enter to search bar \"([^\"]*)\"$")
    public void enterToSearchBar(String arg0) {
        $(By.xpath("//*[@id='search']/form/div/div/input")).sendKeys(Keys.ESCAPE);
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
        $$(By.xpath("//*[@id='subscribe-button']/ytd-button-renderer/a")).get(4).waitUntil(text(arg0),5000);
        Thread.sleep(1000);
        $$(By.xpath("//*[@id='subscribe-button']/ytd-button-renderer/a")).get(4).click();
    }

    @Then("^can see login image$")
    public void canSeeLoginImage() {
        $(By.xpath("//*[@class='style-scope ytd-topbar-menu-button-renderer no-transition']")).waitUntil(visible,3000);
    }

    @Then("^Button should change name to \"([^\"]*)\"$")
    public void buttonShouldChangeNameTo(String arg0) throws Throwable {
        $(By.xpath("//*[@aria-label='Unsubscribe from Heisenbug.']/yt-formatted-string")).shouldHave(text(arg0));
    }

    @When("^press \"([^\"]*)\" button as logined user$")
    public void pressButtonAsLoginedUser(String arg0) throws Throwable {
        $(By.xpath("//*[@aria-label='Subscribe to Heisenbug.']")).waitUntil(text(arg0),5000);
        Thread.sleep(1000);
        $(By.xpath("//*[@aria-label='Subscribe to Heisenbug.']")).click();
        //*[@aria-label='Subscribe to Heisenbug.']
    }

    @When("^press this button again$")
    public void pressThisButtonAgain() {
        $(By.xpath("//*[@aria-label='Unsubscribe from Heisenbug.']")).click();
        $(By.xpath("//*[@class='style-scope yt-button-renderer style-blue-text size-default']")).click();
    }

    @Then("^can see button with \"([^\"]*)\"$")
    public void canSeeButtonWith(String arg0) throws Throwable {
        $(By.xpath("//*[@aria-label='Subscribe to Heisenbug.']")).waitUntil(text(arg0),5000);
    }
}
