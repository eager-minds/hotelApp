package tech.eagerminds.showcase.bdd;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tech.eagerminds.showcase.bdd")
public class CucumberTest {

  private static final Logger LOG = LoggerFactory.getLogger(CucumberTest.class);

  @BeforeAll
  public static void initExec() {
    LOG.info("CucumberTest - Starting execution");
  }
}