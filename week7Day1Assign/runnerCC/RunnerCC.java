package runnerCC;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import stepDefinitions.BaseClassCC;

@CucumberOptions(features = "week7Day1Assign/feature", 
				glue = "stepDefinitions", 
				monochrome = true,
				publish = true,
				dryRun = false,
				snippets = SnippetType.CAMELCASE)

public class RunnerCC extends BaseClassCC{

}
