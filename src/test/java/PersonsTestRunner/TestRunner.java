package PersonsTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "PersonsStepDefinitions",
        features = "src/test/resources/persons"
)
public class TestRunner {
}
