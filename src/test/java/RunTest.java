import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Acer on 17/01/2017.
 */




@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Resources",
        format = {"json:target/Nopecommerce_report.jason"},
        tags = "@Register"
)
public class RunTest {
}
