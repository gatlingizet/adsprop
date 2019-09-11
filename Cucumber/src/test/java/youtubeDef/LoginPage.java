package youtubeDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public static String getDataProperties(String param) throws Exception {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), "UTF-8"));
        return props.getProperty(param);
    }

    @Then("^can see Google form with login name and text \"([^\"]*)\"$")
    public void canSeeGoogleFormWithLoginNameAndText(String arg0) {
        $(By.xpath("//*[@class='AxOyFc snByac']")).waitUntil(visible, 20000);
        $(By.xpath("//*[@class='AxOyFc snByac']")).shouldHave(text(arg0));
    }

    @Given("^browser with opened YouTube and logined$")
    public void browserWithOpenedYouTubeAndLogined() throws Exception {
        openYoutube();
        logintoYoutube();

    }

    private void openYoutube () throws Exception {
        open(getDataProperties("link"));
        $(By.xpath("//*[@id='buttons']/ytd-button-renderer/a")).waitUntil(visible, 4000);
        $(By.xpath("//*[@id='buttons']/ytd-button-renderer/a")).click();
    }

    private void logintoYoutube() throws Exception {
        canSeeGoogleFormWithLoginNameAndText("Email or phone");
        $(By.xpath("//*[@type='email']")).setValue(getDataProperties("login"));
        $(By.xpath("//*[@class='CwaK9']")).click();
        $(By.xpath("//*[@type='password']")).setValue(getDataProperties("password"));
        $(By.xpath("//*[@class='CwaK9']")).click();
        Thread.sleep(3000);


    }
}
