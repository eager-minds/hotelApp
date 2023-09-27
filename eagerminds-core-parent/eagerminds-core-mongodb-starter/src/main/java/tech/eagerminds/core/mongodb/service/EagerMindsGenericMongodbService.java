package tech.eagerminds.core.mongodb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EagerMindsGenericMongodbService<E, I> {

  MongoRepository<E, I> getMongoRepository();

  default List<E> findAll() {
    return getMongoRepository().findAll();
  }

  default Optional<E> findById(I id) {
    return getMongoRepository().findById(id);
  }

  default E save(E e) {
    return getMongoRepository().save(e);
  }

  E update(I id, E e);

  default void deleteById(I id) {
    getMongoRepository().deleteById(id);
  }

  default void deleteAll() {
    getMongoRepository().deleteAll();
  }
}
