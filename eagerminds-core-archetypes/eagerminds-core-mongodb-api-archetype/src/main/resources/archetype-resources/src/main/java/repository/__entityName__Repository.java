package ${package}.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ${package}.domain.entity.${entityName}Entity;

@Repository
public interface ${entityName}Repository
    extends MongoRepository<${entityName}Entity, String> {

}
