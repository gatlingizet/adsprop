package youtubeDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Then("^can see Google form with login name and text \"([^\"]*)\"$")
    public void canSeeGoogleFormWithLoginNameAndText(String arg0) throws Throwable {
        $(By.xpath("//*[@class='AxOyFc snByac']")).waitUntil(visible, 20000);
        $(By.xpath("//*[@class='AxOyFc snByac']")).shouldHave(text(arg0));
    }
}
