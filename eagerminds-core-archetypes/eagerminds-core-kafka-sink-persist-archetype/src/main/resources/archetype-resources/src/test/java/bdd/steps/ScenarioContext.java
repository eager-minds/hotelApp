package ${package}.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;

@ScenarioScope
@Component
public class ScenarioContext {

  private ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key;
  private ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value;

  public ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key() {
    return ${topicEntityNameLowerCamelCase}Key;
  }

  public void set${topicEntityName}Key(
      ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key) {
    this.${topicEntityNameLowerCamelCase}Key = ${topicEntityNameLowerCamelCase}Key;
  }

  public ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value() {
    return ${topicEntityNameLowerCamelCase}Value;
  }

  public void set${topicEntityName}Value(
      ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value) {
    this.${topicEntityNameLowerCamelCase}Value = ${topicEntityNameLowerCamelCase}Value;
  }
}
