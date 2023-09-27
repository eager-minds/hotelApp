package ${package}.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ${package}.domain.entity.${topicEntityName}Entity;

@Repository
public interface ${topicEntityName}Repository
    extends ReactiveMongoRepository<${topicEntityName}Entity, String> {

}
