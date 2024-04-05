package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= "classpath:Features/login.feature",
		glue= "stepDefinitions",
		dryRun= false,//true means we can see step defined for each feature file statement
		monochrome= true,//remove unwanted character from console
		plugin= {"pretty",
		        "html:test-output", // generates a HTML report
		        
		}
		
		
		
		)



public class TestRun {

}
