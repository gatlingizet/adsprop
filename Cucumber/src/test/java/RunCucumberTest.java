import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions

        (plugin = {"pretty", "json:target/cucumber.json"},
                features = "src/test/resources/youtubeFeatures",
                glue = {"youtubeDef"}
//                , tags = {"@"}
        )

public class RunCucumberTest {
}
